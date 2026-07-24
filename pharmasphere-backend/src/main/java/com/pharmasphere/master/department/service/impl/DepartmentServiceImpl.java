/**
 * Department Service Implementation.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 24-07-2026
 */
package com.pharmasphere.master.department.service.impl;

import org.springframework.stereotype.Service;
import com.pharmasphere.master.department.repository.DepartmentRepository;
import com.pharmasphere.master.department.service.DepartmentService;
import java.util.List;
import com.pharmasphere.master.department.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

}