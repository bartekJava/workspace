package pl.altkom.hibernatejpa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.altkom.hibernatejpa.model.Borrower;
import pl.altkom.hibernatejpa.repositories.BorrowerRepository;
import pl.altkom.hibernatejpa.utils.CustomEvent;

@Service
//@Profile("test")
public class BorrowerServiceImpl implements BorrowerService {
	
	@Autowired
	private BorrowerRepository repository;
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
	
	public Borrower findById(long id) {

		return repository.findOne(id);
	}

	public Borrower saveBorrower(Borrower borrower) {
		repository.save(borrower);
		publishAnEvent("Saved Borrower: " + borrower.getFirstName() + " " + borrower.getLastName());
		return borrower;
	}

	public void updateBorrower(Borrower borrower) {
		saveBorrower(borrower);
		publishAnEvent("Updated Borrower: " + borrower.getFirstName() + " " + borrower.getLastName());
	}

	public void deleteBorrowerBySsn(String ssn) {
		repository.deleteBySsn(ssn);
		publishAnEvent("Deleted Borrower Number: " + ssn);
	}

	public List<Borrower> findAllBorrowers() {
		return repository.findAll();
	}

	public Borrower findBorrowerBySsn(String ssn) {
		return repository.findBySsn(ssn);
	}

	public boolean isBorrowerSsnUnique(Long id, String ssn) {
		Borrower borrower = findBorrowerBySsn(ssn);
        return ( borrower == null || ((id != null) && (borrower.getId() == id)));
	}

	public List<Borrower> findByReturnDate(LocalDate returnDate) {
		return repository.findByQuery(returnDate);
	}

	@Override
	public void test() {
		System.out.println("from test method");
		
	}
	
	public void publishAnEvent(final String message) {
        System.out.println("Publishing custom event. ");
        CustomEvent customEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customEvent);
    }

	
	public boolean isBorrowerExist(Borrower borrower) {
		boolean result = repository.findBySsn(borrower.getSsn()) != null;
		return result;
	}

	@Override
	public void deleteById(long id) {
		repository.delete(id);
		
	}

	@Override
	public void deleteAllBorrowers() {
		repository.deleteAll();
	}

}
