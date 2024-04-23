package com.sahoo.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.sahoo.service.BankLoanService;

@DisplayName("TestingBankLoanService")
@TestMethodOrder(value = OrderAnnotation.class)
public class BankLoanServiceTest {

	//private BankLoanService service;
	private static BankLoanService service;
	
	@BeforeAll
	public static void createOnce()
	{
		System.out.println("BankLoanServiceTest.createOnce()");
		service = new BankLoanService();
	}
	 
	/*@BeforeEach
	public void setUP()
	{
		System.out.println("BankLoanServiceTest.setUP()");
		service = new BankLoanService();
	}*/
	@Test
	@DisplayName("test with less amount")
	@Order(1)
	@Tag("uat")
	public void calcSimpleIntrestAmountTestWithSmallAmount()
	{
		 System.out.println("BankLoanServiceTest.calcSimpleIntrestAmountTestWithSmallAmount()");
		float actual = service.calcSimpleIntrestAmount(100000, 5, 2);
		float expected = 10000;
		Assertions.assertEquals(expected, actual, "may be result not matching");
	}
	@Test
	@Disabled
	@DisplayName("test with larger amount")
	@Order(4)
	@Tag("dev")
	public void calcSimpleIntrestAmountTestWithBigAmount()
	{
		 System.out.println("BankLoanServiceTest.calcSimpleIntrestAmountTestWithBigAmount()");
		float actual = service.calcSimpleIntrestAmount(600000, 5, 2);
		float expected = 60000;
		Assertions.assertEquals(expected, actual,"may be result not matching");
	}
	@Test
	@DisplayName("test with invalid input")
	@Order(5)
	@Tag("uat")
	public void calcSimpleIntrestAmountTestWithInvalidInput()
	{
		 System.out.println("BankLoanServiceTest.calcSimpleIntrestAmountTestWithInvalidInput()");
		 Assertions.assertThrows(IllegalArgumentException.class, ()->{
			 service.calcSimpleIntrestAmount(0, 0, 0);
			 
		 },"may be exception not matching");
	}
	
	@Test
	@DisplayName("test performance")
	@Order(2)
	@Tag("uat")
	public void calcSimpleIntrestAmountTestWithPerformanceTimer()
	{
		 System.out.println("BankLoanServiceTest.calcSimpleIntrestAmountTestWithPerformanceTimer()");
		 Assertions.assertTimeout(Duration.ofMillis(6000), ()->{
			 service.calcSimpleIntrestAmount(1000000, 5, 2);
		 });
	}
	@Test
	@DisplayName("test with positive input no exception")
	@Order(3)
	@Tag("dev")
	public void calcSimpleIntrestAmountTestNoExceptionForPositiveInput()
	{
		 System.out.println("BankLoanServiceTest.calcSimpleIntrestAmountTestNoExceptionForPositiveInput()");
		 Assertions.assertDoesNotThrow(()->{
			 service.calcSimpleIntrestAmount(900000, 10, 2);
		 });
	}
	/*@AfterEach
	public void clear()
	{
		System.out.println("BankLoanServiceTest.clear()");
		service = null;
	}*/
	@AfterAll
	public static void clearOnce()
	{
		System.out.println("BankLoanServiceTest.clearOnce()");
		service = null;
	}
}
