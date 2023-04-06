package com.avd.employeeservice.service;

import com.avd.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/departments/{code}")
    DepartmentDto getDepartmentByDepartmentCode(@PathVariable("code") String departmentCode);
}
