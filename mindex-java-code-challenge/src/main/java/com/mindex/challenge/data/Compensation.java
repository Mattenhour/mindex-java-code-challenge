package com.mindex.challenge.data;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Compensation
{
	private Employee employee;
	private Float salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate effectiveDate;
	
	public Compensation() {}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	
}
