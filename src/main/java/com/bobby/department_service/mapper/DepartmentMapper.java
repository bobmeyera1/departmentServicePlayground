package com.bobby.department_service.mapper;

import com.bobby.department_service.dto.DepartmentDto;
import com.bobby.department_service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto toDto(Department department);
    Department toEntity(DepartmentDto dto);
}
