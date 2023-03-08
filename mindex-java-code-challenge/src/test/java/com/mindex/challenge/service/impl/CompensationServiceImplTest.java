package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest
{
	@Mock
	CompensationService mockCompensationService;
	
	@Test
	public void testReadCompensation()
	{
		// create Employee
		String testId = "edd3-4847-99fe";
		
		Employee testEmployee = new Employee();
		testEmployee.setEmployeeId(testId);
        testEmployee.setFirstName("John");
        testEmployee.setLastName("Doe");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Developer");
		
		// create Compensation
        String date = "2023-03-06";
        LocalDate localDate = LocalDate.parse(date);
        
        Compensation testCompensation = new Compensation();
        testCompensation.setSalary(500.00f);
        testCompensation.setEffectiveDate(localDate);
        testCompensation.setEmployee(testEmployee);
        
        Mockito
        	.when(mockCompensationService.read(testId))
        	.thenReturn(testCompensation);
        
        Compensation returnedCompensation = mockCompensationService.read(testId);
        
        assertNotNull(returnedCompensation.getEmployee());
        
        assertEquals(returnedCompensation.getSalary(), testCompensation.getSalary());
	}
}
