package com.bobby.department_service.controller;

import com.bobby.department_service.dto.DepartmentDto;
import com.bobby.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto department) {
        DepartmentDto saved = departmentService.saveDepartment(department);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/code/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto dto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{department-id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-id") Long departmentId) {
        Optional<DepartmentDto> dto = departmentService.findDepartmentById(departmentId);
        return dto.map(departmentDto -> new ResponseEntity<>(departmentDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
