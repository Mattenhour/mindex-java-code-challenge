package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService
{
	@Autowired
    private EmployeeService employeeService;
	
	@Override
    public ReportingStructure getReportingStructure(String id)
    {
    	int numberOfReports = calculateNumberOfReports(id);
    	
    	Employee emp = employeeService.read(id);
    	
    	return new ReportingStructure(emp, numberOfReports);
    }
    
	/**
	 * Because counting all directReports is similar to traveling down 
	 * a tree type structure it is perfect for using a Recursive Algorithm  
	 * 
	 * @param id an employee's id
	 * @return an int that represents the number of reports under an employee
	 */
    private int calculateNumberOfReports(String id)
    {
    	int reportsCount = 0;
    	
    	Employee emp = employeeService.read(id);
    	
    	if(emp.getDirectReports() == null) { return reportsCount;}
    	
    	for(Employee employee: emp.getDirectReports())
    	{
    		reportsCount += (1 + calculateNumberOfReports(employee.getEmployeeId()));
    	}
    	
    	return reportsCount;
    }
}
