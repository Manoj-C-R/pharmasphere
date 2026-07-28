package com.pharmasphere.master.department.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Department Request DTO.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 28-07-2026
 */
@Data
public class DepartmentRequest {

    @NotBlank(message = "Department code is required.")
    @Size(max = 20, message = "Department code cannot exceed 20 characters.")
    private String departmentCode;

    @NotBlank(message = "Department name is required.")
    @Size(max = 100, message = "Department name cannot exceed 100 characters.")
    private String departmentName;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

}