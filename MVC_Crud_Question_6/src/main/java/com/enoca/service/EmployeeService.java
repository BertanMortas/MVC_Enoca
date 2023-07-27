package com.enoca.service;

import com.enoca.dto.request.CreateEmployeeRequestDto;
import com.enoca.dto.request.UpdateEmployeeRequestDto;
import com.enoca.entity.Employee;
import com.enoca.exception.ErrorType;
import com.enoca.exception.Question6Exception;
import com.enoca.mapper.IEmployeeMapper;
import com.enoca.repository.IEmployeeRepository;
import com.enoca.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends ServiceManager<Employee,Long> {
    private final IEmployeeRepository employeeRepository;
    private final CompanyService companyService;

    public EmployeeService(IEmployeeRepository employeeRepository, CompanyService companyService) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
    }
    public Boolean CreateEmployee(CreateEmployeeRequestDto dto){
        Employee employee = IEmployeeMapper.INSTANCE.toEmployee(dto);
        save(employee);
        return true;
    }

    public Boolean update(UpdateEmployeeRequestDto dto){
        if(!companyService.isCompanyExist(dto.getCompanyId()))
            throw new Question6Exception(ErrorType.COMPANY_NOT_FOUND);
        Employee employee = employeeRepository.findById(dto.getEmployeeId()).orElseThrow(()->{
            throw new Question6Exception(ErrorType.EMPLOYEE_NOT_FOUND);
        });
        Employee updatedEmployee = IEmployeeMapper.INSTANCE.toEmployee(dto,employee);
        update(updatedEmployee);
        return true;
    }
}
