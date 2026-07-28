/**
 * Department Service Implementation.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 24-07-2026
 */
package com.pharmasphere.master.department.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pharmasphere.exception.DuplicateResourceException;
import com.pharmasphere.exception.ResourceNotFoundException;
import com.pharmasphere.master.department.dto.DepartmentRequest;
import com.pharmasphere.master.department.dto.DepartmentResponse;
import com.pharmasphere.master.department.entity.Department;
import com.pharmasphere.master.department.repository.DepartmentRepository;
import com.pharmasphere.master.department.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public List<DepartmentResponse> getAllDepartments() {

    	return departmentRepository.findByActiveTrue()
    	        .stream()
    	        .map(this::mapToResponse)
    	        .toList();
    }
    
    @Override
    public DepartmentResponse getDepartmentById(Integer departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found."));

        return mapToResponse(department);
    }
    
    @Override
    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {

    	Map<String, String> errors = new HashMap<>();

    	if (departmentRepository.existsByDepartmentCode(departmentRequest.getDepartmentCode())) {
    	    errors.put("departmentCode", "Department code already exists.");
    	}

    	if (departmentRepository.existsByDepartmentName(departmentRequest.getDepartmentName())) {
    	    errors.put("departmentName", "Department name already exists.");
    	}

    	if (!errors.isEmpty()) {
    	    throw new DuplicateResourceException(errors);
    	}
    	
        Department department = new Department();

        department.setDepartmentCode(departmentRequest.getDepartmentCode());
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setDescription(departmentRequest.getDescription());

        department.setActive(true);
        department.setCreatedBy("SYSTEM");
        department.setCreatedDate(LocalDateTime.now());

        Department savedDepartment = departmentRepository.save(department);

        return mapToResponse(savedDepartment);
    }
    
    @Override
    public DepartmentResponse updateDepartment(Integer departmentId,
            DepartmentRequest departmentRequest) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found."));

        Map<String, String> errors = new HashMap<>();

        if (departmentRepository.existsByDepartmentCodeAndDepartmentIdNot(
                departmentRequest.getDepartmentCode(), departmentId)) {

            errors.put("departmentCode", "Department code already exists.");
        }

        if (departmentRepository.existsByDepartmentNameAndDepartmentIdNot(
                departmentRequest.getDepartmentName(), departmentId)) {

            errors.put("departmentName", "Department name already exists.");
        }

        if (!errors.isEmpty()) {
            throw new DuplicateResourceException(errors);
        }

        department.setDepartmentCode(departmentRequest.getDepartmentCode());
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setDescription(departmentRequest.getDescription());

        department.setUpdatedBy("SYSTEM");
        department.setUpdatedDate(LocalDateTime.now());

        Department updatedDepartment = departmentRepository.save(department);

        return mapToResponse(updatedDepartment);
    }
    
    /**
     * Converts Department Entity to DepartmentResponse DTO.
     *
     * @param department Department entity
     * @return Department response DTO
     */
    private DepartmentResponse mapToResponse(Department department) {

        DepartmentResponse response = new DepartmentResponse();

        response.setDepartmentId(department.getDepartmentId());
        response.setDepartmentCode(department.getDepartmentCode());
        response.setDepartmentName(department.getDepartmentName());
        response.setDescription(department.getDescription());
        response.setActive(department.getActive());

        return response;
    }
    
    @Override
    public void deleteDepartment(Integer departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found."));

        if (!department.getActive()) {
            throw new ResourceNotFoundException("Department is already inactive.");
        }

        department.setActive(false);
        department.setUpdatedBy("SYSTEM");
        department.setUpdatedDate(LocalDateTime.now());

        departmentRepository.save(department);
    }

}