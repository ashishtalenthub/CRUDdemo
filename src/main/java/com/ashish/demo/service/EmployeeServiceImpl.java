package com.ashish.demo.service;

import com.ashish.demo.dao.EmployeeDAO;
import com.ashish.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO ;

    // customer injection
    @Autowired
    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
         employeeDAO.deleteById(theId);
    }
}
