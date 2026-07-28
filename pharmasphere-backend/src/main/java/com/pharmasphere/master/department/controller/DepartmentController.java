/**
 * Department Controller.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 24-07-2026
 */
package com.pharmasphere.master.department.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;


import com.pharmasphere.common.ApiResponse;
import com.pharmasphere.master.department.entity.Department;
import com.pharmasphere.master.department.service.DepartmentService;
import com.pharmasphere.master.department.dto.DepartmentResponse;
import com.pharmasphere.master.department.dto.DepartmentRequest;


@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllDepartments() {

        List<DepartmentResponse> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        "Departments retrieved successfully.",
                        departments));
    }
    
    @GetMapping("/{departmentId}")
    public ResponseEntity<ApiResponse> getDepartmentById(@PathVariable Integer departmentId) {

    	DepartmentResponse department = departmentService.getDepartmentById(departmentId);

        return ResponseEntity.ok(
                new ApiResponse(true, "Department fetched successfully.", department)
        );

    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createDepartment(
    		@Valid  @RequestBody DepartmentRequest departmentRequest) {

    	DepartmentResponse department = departmentService.createDepartment(departmentRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true,
                        "Department created successfully.",
                        department));
    }
    
    @PutMapping("/{departmentId}")
    public ResponseEntity<ApiResponse> updateDepartment(
            @PathVariable Integer departmentId,
            @Valid @RequestBody DepartmentRequest departmentRequest) {

    	DepartmentResponse department = departmentService.updateDepartment(  departmentId, departmentRequest);

        return ResponseEntity.ok(
                new ApiResponse(true,
                        "Department updated successfully.",
                        department)
        );
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<ApiResponse> deleteDepartment(
            @PathVariable Integer departmentId) {

        departmentService.deleteDepartment(departmentId);

        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        "Department deleted successfully.",
                        null));
    }
}