package com.websystique.testng;
 
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
 
public class TestBackendConfig {
 
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite\n");
    }
  
    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }
     
    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }
  
    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest\n");
    }
     
}