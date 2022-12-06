package com.example.employee.service;

import com.example.employee.dto.mapper.mapper;
import com.example.employee.dto.request.EmployeeRequest;
import com.example.employee.dto.response.EmployeeResponse;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repository.EmployeeReposity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeReposity employeeRepository;

    public EmployeeServiceImpl(EmployeeReposity employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

//    Using Request and Response with save and update employee

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = mapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeRepository.save(employeeEntity);
        return mapper.MAPPER.fromEntityToResponse(employeeEntity);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {

        Optional<EmployeeEntity> checkExistingEmployee = findById(id);
        if (! checkExistingEmployee.isPresent())
            throw new RuntimeException("Employee Id "+ id + " Not Found!");

        EmployeeEntity employeeEntity = mapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeEntity.setId(id);
        employeeRepository.save(employeeEntity);
        return mapper.MAPPER.fromEntityToResponse(employeeEntity);
    }

}