package com.websystique.testng;
 
import java.util.List;
 
public interface EmployeeService {
 
    void saveEmployee(Employee employee);
 
    List<Employee> findAllEmployees();
 
    void deleteEmployeeBySsn(String ssn);
}