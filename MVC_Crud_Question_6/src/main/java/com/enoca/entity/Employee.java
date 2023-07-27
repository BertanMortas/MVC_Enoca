package com.enoca.entity;

import com.enoca.entity.enums.EGender;
import com.enoca.entity.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String surname;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EStatus eStatus = EStatus.PENDING;
    @Enumerated(EnumType.STRING)
    private EGender eGender;
    private Double salary;
    private Long companyId;
}
