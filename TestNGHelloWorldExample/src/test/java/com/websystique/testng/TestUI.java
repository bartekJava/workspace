package com.websystique.testng;
 
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class TestUI {
 
    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }
  
    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest\n");
    }
     
    @Test(groups= "ui")
    public void openConfirmationDialog() {
        System.out.println("openConfirmationDialog()");
    }
 
    @Test(groups= "ui")
    public void openFileDialog() {
        System.out.println("openFileDialog()");
    }
 
}