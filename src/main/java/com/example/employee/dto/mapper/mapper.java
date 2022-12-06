package com.example.employee.dto.mapper;

import com.example.employee.dto.request.EmployeeRequest;
import com.example.employee.dto.response.EmployeeResponse;
import com.example.employee.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface mapper {
    mapper MAPPER = Mappers.getMapper(mapper.class);
    EmployeeEntity fromRequestToEntity(EmployeeRequest employeeRequest);
    EmployeeResponse fromEntityToResponse(EmployeeEntity employeeEntity);
}