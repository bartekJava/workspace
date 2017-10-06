package pl.altkom.hibernatejpa.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.DataIntegrityViolationException;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pl.altkom.hibernatejpa.model.Borrower;
import pl.altkom.hibernatejpa.repositories.BorrowerRepository;
import pl.altkom.hibernatejpa.utils.CustomEvent;

public class BorrowerServiceImplTest {

	@Mock
	BorrowerRepository repository;
	
	@Mock
	private ApplicationEventPublisher applicationEventPublisher;
	
	@InjectMocks
	BorrowerServiceImpl borrowerService;
	
	@Spy
    List<Borrower> borrowers = new ArrayList<>();
	
	@Captor
    ArgumentCaptor<Borrower> captor;
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        borrowers = getBorrowers();
    }
	
	@AfterMethod
	public void test() {
		reset(repository);
		reset(applicationEventPublisher);
	}
	
	
	
	@Test
    public void findBorrowerById(){
        Borrower borrower = borrowers.get(0);
        
        when(repository.findOne(anyLong())).thenReturn(borrower);
        doNothing().when(applicationEventPublisher).publishEvent(any(CustomEvent.class));
        
        Borrower foundBorrower = borrowerService.findById(1L);
        
        verify(repository, times(1)).findOne(anyLong());
        assertEquals(foundBorrower, borrower);
    }
	
	
	@Test
	void saveNewBorrower() {
		Borrower borrower = borrowers.get(0);
		
		when(repository.save(any(Borrower.class))).thenReturn(any(Borrower.class));
		
		borrowerService.saveBorrower(borrower);
		
		verify(repository, times(1)).save(captor.capture());
		assertEquals(captor.getValue().getFirstName(), "John");
	}
	
	
	@Test(expectedExceptions = DataIntegrityViolationException.class)
	void failTosaveExistingBorrower() {
		
		doThrow(DataIntegrityViolationException.class).when(repository).save(any(Borrower.class));
		
		borrowerService.saveBorrower(borrowers.get(0));
	}
	
	
	@Test
	void deleteBorrowerBySsn() {
		doNothing().when(repository).deleteBySsn(anyString());
		doNothing().when(applicationEventPublisher).publishEvent(any(CustomEvent.class));
		
        borrowerService.deleteBorrowerBySsn(anyString());
        
        verify(repository, times(1)).deleteBySsn(anyString());
	}
	
	
	@Test(expectedExceptions = AssertionError.class)
	void failTodeleteBorrowerByNonExistingSsn() {
		doThrow(AssertionError.class).when(repository).deleteBySsn(anyString());
		
        borrowerService.deleteBorrowerBySsn("70010100112");
        
        verify(repository, atLeastOnce()).deleteBySsn(anyString());
	}
	
	
	@Test
	void findAllBorrowers() {
		when(repository.findAll()).thenReturn(borrowers);
		
        List<Borrower> foundBorrowers = borrowerService.findAllBorrowers();
		
        verify(repository, times(1)).findAll();
        assertEquals(foundBorrowers, borrowers);
	}
	
	
	@Test
	void isBorrowerSsnUnique() {
		Borrower borrower = borrowers.get(0);
		long id = borrower.getId();
		String ssn = borrower.getSsn();
		
		when(repository.findBySsn(anyString())).thenReturn(borrower);
		
		boolean unique = borrowerService.isBorrowerSsnUnique(id, ssn);
		
		assertEquals(unique, true);
	}
	
	
	@Test
	void findByReturnDate() {	
		when(repository.findByQuery(any(LocalDate.class))).thenReturn(borrowers);
		
		List<Borrower> foundBorrowers = borrowerService.findByReturnDate(any(LocalDate.class));
		
		verify(repository, times(1)).findByQuery(any(LocalDate.class));
		assertEquals(foundBorrowers, borrowers);
	}
	
	
		
	public List<Borrower> getBorrowers(){
		Borrower borrower1 = new Borrower();
		borrower1.setId(1L);
		borrower1.setFirstName("John");
		borrower1.setLastName("Doe");
		borrower1.setSsn("70010100111");
         
		Borrower borrower2 = new Borrower();
		borrower2.setId(2L);
		borrower2.setFirstName("Jane");
		borrower2.setLastName("Doe");
		borrower2.setSsn("80020200222");
         
		borrowers.add(borrower1);
		borrowers.add(borrower2);
        return borrowers;
    }
}
