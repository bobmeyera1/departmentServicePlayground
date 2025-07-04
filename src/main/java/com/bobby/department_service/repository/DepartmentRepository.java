package com.bobby.department_service.repository;

import com.bobby.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode) ;

    Optional<Department> findOptionalById(Long id);

}
