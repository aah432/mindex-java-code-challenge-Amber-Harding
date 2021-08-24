//Author: Amber Harding
//Reporting Controller
package com.mindex.challenge.controller;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.impl.ReportingStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingController {

    private ReportingStructure reportingStructure;
    private Employee employee;

    @Autowired
    private EmployeeRepository employeeRepository;

    //returns Reporting Structure. Not formatted. Prints full set.
    @GetMapping("/report/{id}")
    public ReportingStructure reportingStructure(@PathVariable String id){
        employee = employeeRepository.findByEmployeeId(id);
        return new ReportingStructure(employee);
    }

}
