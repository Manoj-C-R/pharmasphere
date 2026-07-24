/**
 * Department Repository.
 *
 * @author Manoj C R
 * @version 1.0.0
 * @since 24-07-2026
 */
package com.pharmasphere.master.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmasphere.master.department.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}