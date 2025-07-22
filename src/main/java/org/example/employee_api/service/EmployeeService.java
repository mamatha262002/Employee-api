package org.example.employee_api.service;


import org.example.employee_api.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.example.employee_api.model.employee1;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService
{
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }
    //creating or Update
    public employee1 save(employee1 employee )
    {
        return employeeRepository.save(employee);
    }

    public List<employee1> findAll(){
        return employeeRepository.findAll();
    }

    public employee1 findById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with id" + id));
    }

    public void deleteById(Long id){
        if(!employeeRepository.existsById(id)){
            throw new NoSuchElementException("Employee not found with id" + id);
        }
        employeeRepository.deleteById(id);
    }
}
