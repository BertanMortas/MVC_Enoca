package com.enoca.controller;

import com.enoca.dto.request.CreateCompanyRequestDto;
import com.enoca.dto.request.UpdateCompanyRequestDto;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.enoca.service.CompanyService;
import com.enoca.entity.Company;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import static com.enoca.constants.ApiUrls.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping(FIND_ALL)
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Company> companyList = companyService.findAll();
        try{
            modelAndView.addObject("companyList",companyList);
            modelAndView.setViewName("companyList");
        }catch (Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("findAll");
        }
        return modelAndView;
    }

    @PutMapping(UPDATE)
    public ModelAndView update(UpdateCompanyRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            companyService.updateCompany(dto);
            modelAndView.addObject("companyName",dto.getCompanyName());
            modelAndView.addObject("sector",dto.getSector());
        }catch (Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("update");
        }
        return modelAndView;
    }

    @PostMapping(SAVE)
    public ModelAndView save(CreateCompanyRequestDto dto){
        ModelAndView modelAndView = new ModelAndView();
        try {
            companyService.createCompany(dto);
            modelAndView.addObject("companyName", dto.getCompanyName());
            modelAndView.addObject("sector", dto.getSector());
        }catch (Exception e){
            modelAndView.addObject("error", e.getMessage());
            modelAndView.setViewName("save");
        }
        return modelAndView;
    }

    @DeleteMapping(DELETE)
    public ModelAndView delete(Long companyId){
        companyService.deleteById(companyId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delete");
        return modelAndView;
    }




}
