package com.enoca.dto.request;

import com.enoca.entity.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CreateEmployeeRequestDto {
    private String name;
    private String surname;
    private EGender eGender;
    private Double salary;
    @NotEmpty
    private Long companyId;
}
