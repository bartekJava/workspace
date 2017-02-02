package com.websystique.testng;
 
public class Calculator {
     
    public double add(double a, double b){
        return a+b;
    }
     
    public double subtract(double a, double b) /*throws InterruptedException*/{
//    	Thread.sleep(5000);
        return a-b;
    }
     
    public double multiply(double a, double b){
        return a*b;
    }
    
    public int divide(int a, int b){
        return a/b;
    }
     
}