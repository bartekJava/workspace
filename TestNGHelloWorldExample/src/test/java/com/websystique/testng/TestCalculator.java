//package com.websystique.testng;
//
//import java.lang.reflect.Method;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TestCalculator 
//{
//	Calculator calculator;
//	
//	@BeforeClass
//	public void beforeClass()
//	{
//		System.out.println("@BeforeClass: I run only once, before first test start.");
//		calculator = new Calculator();
//	}
//	
//	@AfterClass
//	public void afterClass()
//	{
//		System.out.println("@AfterClass: I run only once, after all tests have been done.\n");
//		calculator = null;
//	}
//	
//	@BeforeMethod
//	public void beforeEachTestMethod(Method method)
//	{
//		System.out.println("\n@BeforeMethod: I run before each test method. Test to be executed is : "+method.getName());
//	}
//	
//	@AfterMethod
//    public void afterEachTestMethod(Method method)
//	{
//        System.out.println("@AfterMethod: I run after each test method. Test just executed is : "+method.getName()+"\n");
//    }
//	
//	@Test
//	public void testAdd()
//	{
//		System.out.println("@Test add");
//		Assert.assertEquals(calculator.add(2, 3), 5.0);
//	}
//	
//	@Test
//    public void testSubtract()
//	{
//        System.out.println("@Test subtract");
//        Assert.assertTrue(calculator.subtract(5, 3) > 1, "Subtract test failed");
//    }
//	
//	@Test
//    public void testMultiply()
//	{
//        System.out.println("@Test multiply");
//        Assert.assertEquals(calculator.multiply(5, 3) , 15.0);
//    }
//
//}
