package pl.altkom.hibernatejpa.edu.spring;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import pl.altkom.hibernatejpa.repositories.EntityRepositoryTest;
import pl.altkom.hibernatejpa.service.BorrowerService;

public class BorrowerServiceImplIntegrationTest extends EntityRepositoryTest {
	
	@Autowired
	private BorrowerService borrowerService;
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Borrower.xml"));
		return dataSet;
	}
	
	@Test
	void saveBorrower() {
		borrowerService.saveBorrower(getSampleBorrower());
		
		Assert.assertTrue(true);
	}
	
}
