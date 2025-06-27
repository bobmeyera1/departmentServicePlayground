package com.bobby.department_service.service.impl;

import com.bobby.department_service.dto.DepartmentDto;
import com.bobby.department_service.entity.Department;
import com.bobby.department_service.mapper.DepartmentMapper;
import com.bobby.department_service.repository.DepartmentRepository;
import com.bobby.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.MAPPER.toEntity(departmentDto);
        Department saved = repository.save(department);
        return DepartmentMapper.MAPPER.toDto(saved);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = repository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.MAPPER.toDto(department);
    }

    @Override
    public Optional<DepartmentDto> findDepartmentById(Long id) {
        Optional<Department> department = repository.findOptionalById(id);
        if (department.isPresent()){
            DepartmentDto dto = DepartmentMapper.MAPPER.toDto(department.get());
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }
}
