package com.enoca.dto.request;

import com.enoca.entity.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequestDto {
    private Long employeeId;
    private String name;
    private String surname;
    private Double salary;
    private Long companyId;
}
