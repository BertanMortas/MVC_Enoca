package com.enoca.mapper;
import com.enoca.dto.request.CreateEmployeeRequestDto;
import com.enoca.dto.request.UpdateEmployeeRequestDto;
import com.enoca.entity.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee toEmployee(final CreateEmployeeRequestDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee toEmployee(UpdateEmployeeRequestDto dto, @MappingTarget Employee employee);

}