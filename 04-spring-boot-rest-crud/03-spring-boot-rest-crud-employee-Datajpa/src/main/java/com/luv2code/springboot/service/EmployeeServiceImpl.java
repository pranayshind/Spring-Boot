package com.luv2code.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springboot.dao.EmployeeRepository;
import com.luv2code.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //inject EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
       return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        // TODO Auto-generated method stub
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee =null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not found employee  "+theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        // TODO Auto-generated method stub
       return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub
         employeeRepository.deleteById(theId);
    }

}
