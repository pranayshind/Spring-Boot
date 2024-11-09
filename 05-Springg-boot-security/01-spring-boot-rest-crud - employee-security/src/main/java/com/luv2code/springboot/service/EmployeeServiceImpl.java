package com.luv2code.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.dao.EmployeeDAO;
import com.luv2code.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    //inject EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
       return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        // TODO Auto-generated method stub
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        // TODO Auto-generated method stub
       return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteByID(int theId) {
        // TODO Auto-generated method stub
         employeeDAO.deleteByID(theId);
    }

}
