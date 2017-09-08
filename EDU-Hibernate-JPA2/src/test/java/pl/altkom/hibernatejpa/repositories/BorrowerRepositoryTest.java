package pl.altkom.hibernatejpa.repositories;

import javax.validation.ConstraintViolationException;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import pl.altkom.hibernatejpa.model.Borrower;

public class BorrowerRepositoryTest extends EntityRepositoryTest {
	
	@Autowired
	private BorrowerRepository borrowerRepository;

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Borrower.xml"));
        return dataSet;
	}
	
	@Test
    public void findAllBorrowers(){
        Assert.assertEquals(borrowerRepository.findAll().size(), 2);
    }
	
	@Test
    public void findById(){
        Assert.assertNotNull(borrowerRepository.findOne(1L));
        Assert.assertNull(borrowerRepository.findOne(3L));
    }
	
	@Test
	public void findByName() {
		Assert.assertNotNull(borrowerRepository.findByFirstName("John"));
	}
	
	@Test(expectedExceptions= ConstraintViolationException.class)
	public void checkSsnLengthConstraint() {
		borrowerRepository.save(getInvalidSsnBorrower());
	}
	
	@Test
    public void saveBorrower(){
		borrowerRepository.save(getSampleBorrower());
		Assert.assertNotNull(borrowerRepository.findByFirstName("Name"));
        Assert.assertEquals(borrowerRepository.findAll().size(), 3);
    }
	
	@Test
	public void updateBorrower() {
		Borrower borrower = borrowerRepository.findByFirstName("John");
		borrower.setSsn("70010100112");
		borrowerRepository.save(borrower);
		Borrower updatedBorrower = borrowerRepository.findByFirstName("John");
		Assert.assertEquals(updatedBorrower.getSsn(), "70010100112");
	}
	
	@Test
    public void deleteBorrowerBySsn(){
		borrowerRepository.deleteBySsn("70010100111");
        Assert.assertEquals(borrowerRepository.findAll().size(), 1);
    }
	
	public Borrower getSampleBorrower() {
		Borrower borrower = new Borrower();
		borrower.setFirstName("Name");
		borrower.setLastName("Lastname");
		borrower.setSsn("90030300333");
				
		return borrower;
	}
	
	public Borrower getInvalidSsnBorrower() {
		Borrower borrower = new Borrower();
		borrower.setFirstName("Name");
		borrower.setLastName("Lastname");
		borrower.setSsn("900303003334");
		
		return borrower;
	}
}
