package com.mindex.challenge.controller;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.impl.Compensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompensationController {

    private Employee employee;
    private Compensation compensation;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/updateCompensation/{id}/{salary}")
    public Compensation update(@PathVariable String id, @PathVariable int salary){
        employee = employeeRepository.findByEmployeeId(id);
        if(employee.getCompensation() == null){
            compensation = new Compensation(employee, salary);
        }else{
            compensation.updateCompensation(salary);
        }



        return employee.getCompensation();
    }

    @GetMapping("/compensation/{id}")
    public String read(@PathVariable String id){
        employee = employeeRepository.findByEmployeeId(id);
        compensation = employee.getCompensation();

        return compensation.getCompensation();
    }
}
