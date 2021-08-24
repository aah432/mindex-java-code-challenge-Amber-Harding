package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.impl.ReportingStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    //private ReportingStructure reportingStructure;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }

    // ReportingStructure API endpoint. I did this without creating a new type. Lists out names of
    // reports and their IDs. Not formatted.
    // Author: Amber Harding
    @GetMapping("reportingStructure/{id}")
    public String getReportingStructure(@PathVariable String id){
        //Count number of reports
        int totalReports = 0;
        String result = "Employee ID: " + id + "Employee Name: "
                + employeeService.read(id).getFirstName() + " " + employeeService.read(id).getLastName()
                    + "\n Direct Reports: ";
        //Direct reports is a list of Employees which returns Employee objects.
        List<Employee> directReports = employeeService.read(id).getDirectReports();

        //Go through list to get each name and ID of reportee
        for (Employee employee: directReports){
            String employeeId = employee.getEmployeeId();
            result += employeeService.read(employeeId).getFirstName() + " "
                    + employeeService.read(employeeId).getLastName() + " " + employeeId +" ";

            employeeId = "";
            totalReports += 1;
        }
        //Include count of reportees.
        result += " Total Number of Reports: " + totalReports;

        return result;
    }


}
