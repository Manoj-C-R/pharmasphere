package com.pharmasphere.master.department.dto;

import lombok.Data;

/**
 * Department Response DTO.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 28-07-2026
 */
@Data
public class DepartmentResponse {

    private Integer departmentId;

    private String departmentCode;

    private String departmentName;

    private String description;

    private Boolean active;

}