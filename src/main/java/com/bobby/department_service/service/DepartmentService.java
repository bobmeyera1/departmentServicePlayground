package com.bobby.department_service.service;

import com.bobby.department_service.dto.DepartmentDto;

import java.util.Optional;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);

    Optional<DepartmentDto> findDepartmentById(Long id);
}
