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

public interface DepartmentService {

	List<Department> getAllDepartments();
}
