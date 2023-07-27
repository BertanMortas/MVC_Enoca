package com.enoca.controller;

import com.enoca.dto.request.CreateEmployeeRequestDto;
import com.enoca.dto.request.UpdateEmployeeRequestDto;
import com.enoca.entity.Employee;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.enoca.service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.enoca.constants.ApiUrls.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(FIND_ALL)
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employeeList = employeeService.findAll();
        try{
            modelAndView.addObject("employeeList",employeeList);
            modelAndView.setViewName("employeeList");
        }catch (Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("findAll");
        }

        return modelAndView;
    }

    @PutMapping(UPDATE)
    public ModelAndView update(UpdateEmployeeRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        try{
            employeeService.update(dto);
            modelAndView.addObject("name",dto.getName());
            modelAndView.addObject("surname",dto.getSurname());
            modelAndView.addObject("salary",dto.getSalary());
            modelAndView.addObject("companyId",dto.getCompanyId());
        }catch(Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("update");
        }
        return modelAndView;
    }

    @PostMapping(SAVE)
    public ModelAndView save(CreateEmployeeRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        try{
            employeeService.CreateEmployee(dto);
            modelAndView.addObject("name",dto.getName());
            modelAndView.addObject("surname",dto.getSurname());
            modelAndView.addObject("gender",dto.getEGender());
            modelAndView.addObject("salary",dto.getSalary());
            modelAndView.addObject("companyId",dto.getCompanyId());
            return modelAndView;
        }catch (Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("save");
        }
        return modelAndView;
    }

    @DeleteMapping(DELETE)
    public ModelAndView deleteById(Long employeeId){
        employeeService.deleteById(employeeId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delete");
        return modelAndView;
    }



}
