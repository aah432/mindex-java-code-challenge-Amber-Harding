package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;

public class ReportingStructure {

    private final Employee employee;
    private final int numberOfReports;



    public ReportingStructure(Employee employee){
        this.employee = employee;
        this.numberOfReports = this.employee.getDirectReports().size();
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfReports(){
        return numberOfReports;
    }
}
