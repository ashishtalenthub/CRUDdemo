package com.ashish.demo.rest;


import com.ashish.demo.entity.Employee;
import com.ashish.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    // quick and dirty : inject employee dao(use constructor injection)

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;

    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET / employees /{employeeId}

    @GetMapping("/employees/{employeeId}")

    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found -" + employeeId);
        }
        return theEmployee;

    }

    // add mapping for POST /employees  -add new employees

    @PostMapping ("/employees")
    public Employee addEmployee (@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item .. instead of update

        theEmployee.setId(0);
        employeeService.save(theEmployee);

        return theEmployee;
    }

   // add mapping for PUT /employees - update existing employees
   @PutMapping("/employees")
   public Employee updateEmployee (@RequestBody Employee theEmployee){

        employeeService.save(theEmployee);

        return theEmployee;
   }

   @DeleteMapping ("/employees/{employeeId}")
    public String deleteEmployee (@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        // threw exception if null
       if (tempEmployee == null){
           throw new RuntimeException("employee id not found :" + employeeId);
       }

       employeeService.deleteById(employeeId);
       return "Deleted employee id -" + employeeId;
   }

}


