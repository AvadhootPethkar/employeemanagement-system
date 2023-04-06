package com.avd.employeeservice.service;

import com.avd.employeeservice.dto.ApiResponseDto;
import com.avd.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long employeeId);
}
