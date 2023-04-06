package com.avd.departmentservice.service.impl;

import com.avd.departmentservice.dto.DepartmentDto;
import com.avd.departmentservice.entity.Department;
import com.avd.departmentservice.repository.DepartmentRepository;
import com.avd.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
/*
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
*/
        Department department = new Department(departmentDto.getId(),
                departmentDto.getName(), departmentDto.getDescription(), departmentDto.getCode());
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
                savedDepartment.getName(), savedDepartment.getDescription(), savedDepartment.getCode());
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByCode(code);
        DepartmentDto departmentDto = new DepartmentDto(department.getId(),
                department.getName(), department.getDescription(), department.getCode());
        return departmentDto;
    }
}
