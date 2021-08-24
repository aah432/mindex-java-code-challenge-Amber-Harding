package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;

import java.time.LocalDateTime;
import java.util.Date;

public class Compensation {
    private final Employee employee;
    private  int salary = 0;
    private  String effectiveDate = "";

    public Compensation(Employee employee, int salary){
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = LocalDateTime.now().toString();
        this.employee.setCompensation(this);
    }

    public String getCompensation(){
        return "Compensation of Employee " + employee.getFirstName() + " " + employee.getLastName() +
                " Compensation " + salary + " Effective: " + effectiveDate;
    }

    public void updateCompensation(int newSalary){
        this.salary = newSalary;
        this.effectiveDate = LocalDateTime.now().toString();
    }
}
