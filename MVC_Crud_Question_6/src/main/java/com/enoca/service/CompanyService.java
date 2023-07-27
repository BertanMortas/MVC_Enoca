package com.enoca.service;

import com.enoca.dto.request.CreateCompanyRequestDto;
import com.enoca.dto.request.UpdateCompanyRequestDto;
import com.enoca.entity.Company;
import com.enoca.exception.ErrorType;
import com.enoca.exception.Question6Exception;
import com.enoca.mapper.ICompanyMapper;
import com.enoca.repository.ICompanyRepository;
import com.enoca.utility.ServiceManager;
import jdk.dynalink.Operation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService extends ServiceManager<Company,Long> {
    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository){
        super(companyRepository);
        this.companyRepository = companyRepository;
    }
    public void createCompany(CreateCompanyRequestDto dto){
        if (companyRepository.existsByCompanyNameIgnoreCase(dto.getCompanyName())) {
            throw new Question6Exception(ErrorType.COMPANY_DUPLICATE);
        }
        save(ICompanyMapper.INSTANCE.toCompany(dto));
    }
    public void updateCompany(UpdateCompanyRequestDto dto){
        if (!companyRepository.existsByCompanyNameIgnoreCase(dto.getCompanyName())) {
            throw new Question6Exception(ErrorType.COMPANY_NOT_FOUND);
        }
        update(ICompanyMapper.INSTANCE.toCompany(dto));
    }
    public Boolean isCompanyExist(Long id){
        Optional<Company> optionalCompany = findById(id);
        if (optionalCompany.isEmpty()) {
            return false;
        }
        return true;
    }
}
