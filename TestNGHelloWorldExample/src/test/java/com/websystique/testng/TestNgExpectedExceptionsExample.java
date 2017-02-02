package com.websystique.testng;
 
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class TestNgExpectedExceptionsExample {
 
    Calculator calculator;
 
    @BeforeClass
    public void setup() {
        System.out.println("setup()");
        calculator = new Calculator();
    }
 
    @AfterClass
    public void tearDown() {
        System.out.println("tearDown()");
        calculator = null;
    }
 
 
    @Test
    public void testAdd() {
        System.out.println("testAdd()");
        Assert.assertEquals(calculator.add(3, 4), 7);
    }
 
    @Test
    public void testDivide() {
        System.out.println("testDivide()");
        Assert.assertEquals(calculator.divide(16, 4), 4);
    }
     
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        System.out.println("testDivideByZero()");
        Assert.assertEquals(calculator.divide(16, 0), 12345);
    }
     
 
}