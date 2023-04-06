package com.avd.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
    private String code;
}
