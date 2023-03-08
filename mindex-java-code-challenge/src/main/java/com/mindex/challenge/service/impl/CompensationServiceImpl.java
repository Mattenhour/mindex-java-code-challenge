package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;

@Service
public class CompensationServiceImpl implements CompensationService
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompensationRepository compensationRepo;
	
	@Override
	public Compensation read(String empId)
	{	
		Compensation compensation = compensationRepo.findByEmployeeEmployeeId(empId);
		
		if(compensation == null)
		{
			throw new RuntimeException("Compensation was not found for Employee with id " + empId);
		}
		
		return compensation;
	}
	
	@Override
	public Compensation create(String empId, Compensation compensation)
	{
		Employee employee = employeeService.read(empId);
		
		compensation.setEmployee(employee);
		
		compensationRepo.insert(compensation);
		
		return compensation;

	}
}
