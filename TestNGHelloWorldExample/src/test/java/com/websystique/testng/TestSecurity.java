package com.websystique.testng;
 
import org.testng.annotations.Test;
 
public class TestSecurity {
     
    @Test(groups= "security")
    public void accessHomePage() {
        System.out.println("accessHomePage()");
    }
 
    @Test(groups= "security")
    public void accessAdminPage() {
        System.out.println("accessAdminPage()");
    }
 
}