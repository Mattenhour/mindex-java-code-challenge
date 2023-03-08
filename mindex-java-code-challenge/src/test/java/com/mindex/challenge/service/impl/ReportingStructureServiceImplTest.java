package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.ReportingStructure;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest
{
	private String reportingStructureIdUrl;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void setup()
	{
		reportingStructureIdUrl = "http://localhost:" + port + "/calculate-reporting-structure/{id}";
    }
	
	@Test
	public void testReportingStructureNumberOfReports() {
		String johnId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
		
		// Run the reporting structure
		ReportingStructure reportingStructure = restTemplate
				.getForEntity(reportingStructureIdUrl, ReportingStructure.class, johnId)
				.getBody();
		
		assertNotNull(reportingStructure);
		assertEquals(reportingStructure.getNumberOfReports(), 4);
	}
}
