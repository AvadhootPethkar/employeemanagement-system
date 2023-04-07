package com.avd.employeeservice.service.impl;

import com.avd.employeeservice.dto.ApiResponseDto;
import com.avd.employeeservice.dto.DepartmentDto;
import com.avd.employeeservice.dto.EmployeeDto;
import com.avd.employeeservice.entity.Employee;
import com.avd.employeeservice.repository.EmployeeRepository;
import com.avd.employeeservice.service.APIClient;
import com.avd.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(),
                employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getDepartmentCode());
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
                savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

/*
        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);

        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
*/

/*
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
*/

        DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(),
                employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
