package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

public interface CompensationService
{
	Compensation read(String empId);
	Compensation create(String empId ,Compensation compensation);
}
