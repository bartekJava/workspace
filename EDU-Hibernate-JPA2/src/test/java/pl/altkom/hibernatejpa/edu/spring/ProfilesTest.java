package pl.altkom.hibernatejpa.edu.spring;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import pl.altkom.hibernatejpa.model.Borrower;
import pl.altkom.hibernatejpa.repositories.EntityRepositoryTest;
import pl.altkom.hibernatejpa.service.BorrowerService;

@ActiveProfiles("production")
public class ProfilesTest extends EntityRepositoryTest {

	@Autowired
	BorrowerService borrowerService;
	

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Borrower.xml"));
		return dataSet;
	}

	@Test
	void schouldReadBorrowerFromDatabase() {
		String name = "John";

		Borrower borrower = borrowerService.findById(1L);

		Assert.assertEquals(name, borrower.getFirstName());
	}

	@Test
	void schouldReturnPredefinedBorrower() {
		String name = "Predefined FirstName";

		Borrower borrower = borrowerService.findById(1L);

		Assert.assertEquals(name, borrower.getFirstName());
	}

}
