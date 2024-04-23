package com.sahoo.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sahoo.service.CensusService;

public class CensusServiceTest {

	/*@RepeatedTest(value =  10)
	@DisplayName("Testing Export Data")
	public void testExportData()
	{  
		System.out.println("CensusServiceTest.testExportData()");
		CensusService service = new CensusService();
		Assertions.assertEquals("exported data", service.exportData());
	}
	*/
	@ParameterizedTest
	@ValueSource(ints = {10,23,45,36,21})
	public void isTestOdd(int n)
	{
		System.out.println("CensusServiceTest.isTestOdd()");
		CensusService service = new CensusService();
		assertTrue(service.isOdd(n));
	}
}
