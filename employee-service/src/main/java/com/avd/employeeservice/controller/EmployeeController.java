package com.avd.employeeservice.controller;

import com.avd.employeeservice.dto.ApiResponseDto;
import com.avd.employeeservice.dto.EmployeeDto;
import com.avd.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
