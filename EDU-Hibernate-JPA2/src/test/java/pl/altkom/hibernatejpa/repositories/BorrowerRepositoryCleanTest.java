package pl.altkom.hibernatejpa.repositories;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pl.altkom.hibernatejpa.model.Borrower;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@RunWith(SpringRunner.class)
public class BorrowerRepositoryCleanTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	@Test
    public void saveBorrower(){
		borrowerRepository.save(getSampleBorrower());
		Assert.assertNotNull(borrowerRepository.findByFirstName("Name"));
    }
	
	public Borrower getSampleBorrower() {
		Borrower borrower = new Borrower();
		borrower.setFirstName("Name");
		borrower.setLastName("Lastname");
		borrower.setSsn("90030300333");
				
		return borrower;
	}
	
}
