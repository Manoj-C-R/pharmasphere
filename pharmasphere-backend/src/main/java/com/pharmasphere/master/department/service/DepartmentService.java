/**
 * Department Service.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 24-07-2026
 */
package com.pharmasphere.master.department.service;

import java.util.List;
import com.pharmasphere.master.department.entity.Department;
import com.pharmasphere.master.department.dto.DepartmentRequest;
import com.pharmasphere.master.department.dto.DepartmentResponse;

public interface DepartmentService {

	List<DepartmentResponse> getAllDepartments();

	DepartmentResponse getDepartmentById(Integer departmentId);

	DepartmentResponse createDepartment(DepartmentRequest departmentRequest);

	DepartmentResponse updateDepartment(
	        Integer departmentId,
	        DepartmentRequest departmentRequest);
	
	void deleteDepartment(Integer departmentId);
}
