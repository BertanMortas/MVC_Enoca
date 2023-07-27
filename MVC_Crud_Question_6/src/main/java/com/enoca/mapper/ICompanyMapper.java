package com.enoca.mapper;

import com.enoca.dto.request.CreateCompanyRequestDto;
import com.enoca.dto.request.UpdateCompanyRequestDto;
import com.enoca.entity.Company;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyMapper {
    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);
    Company toCompany(final CreateCompanyRequestDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company toCompany(final UpdateCompanyRequestDto dto);
}
