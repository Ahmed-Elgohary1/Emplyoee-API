package com.example.employee.service;

import com.example.employee.dto.request.EmployeeRequest;
import com.example.employee.dto.response.EmployeeResponse;
import com.example.employee.entity.EmployeeEntity;


import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<EmployeeEntity> findAllEmployee();
    Optional<EmployeeEntity> findById(Long id);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);

    //    Using Request for Save and Update Employee
    EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id);


}