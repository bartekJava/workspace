//package com.websystique.testng;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TestNGTimeOutExample {
//
//	Calculator calculator;
//
//	@BeforeClass
//	public void setup() {
//		System.out.println("setup()");
//		calculator = new Calculator();
//	}
//
//	@AfterClass
//	public void tearDown() {
//		System.out.println("tearDown()");
//		calculator = null;
//	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//		System.out.println("beforeMethod()");
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//		System.out.println("afterMethod()");
//	}
//
//	@Test
//	public void testAdd() {
//		System.out.println("testAdd()");
//		Assert.assertEquals(calculator.add(3, 4), 7.0);
//	}
//
//	@Test(timeOut = 3000)//timeout in milliseconds
//	public void testSubtract() throws InterruptedException {
//		System.out.println("testSubtract()");
//		Assert.assertEquals(calculator.subtract(5, 2), 3.0);
//	}
//
//}