/**
 * Department Controller.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 24-07-2026
 */
package com.pharmasphere.master.department.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmasphere.common.ApiResponse;
import com.pharmasphere.master.department.entity.Department;
import com.pharmasphere.master.department.service.DepartmentService;


@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    
    public ResponseEntity<ApiResponse> getAllDepartments() {

        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(
        	    new ApiResponse(true, "Departments fetched successfully.", departments)
        	);
    }

}