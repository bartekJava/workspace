package com.websystique.springmvc.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeDaoImplTest extends EntityDaoImplTest
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	protected IDataSet getDataSet() throws Exception
	{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
		return dataSet;
	}
	
	/* In case you need multiple datasets (mapping different tables) and you do prefer to keep them in separate XML's
    @Override
    protected IDataSet getDataSet() throws Exception {
      IDataSet[] datasets = new IDataSet[] {
              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml")),
              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Benefits.xml")),
              new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Departements.xml"))
      };
      return new CompositeDataSet(datasets);
    }
    */
	
	@Test
	public void findById()
	{
		Assert.assertNotNull(employeeDao.findById(1));
		Assert.assertNull(employeeDao.findById(3));
	}

}
