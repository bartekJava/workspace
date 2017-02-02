package com.websystique.testng;
 
import java.util.List;
 
public class EmployeeServiceImpl implements EmployeeService{
      
    private EmployeeDao dao;
     
    public EmployeeServiceImpl(EmployeeDao dao){
        this.dao = dao;
    }
      
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }
  
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }
  
    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }
  
}