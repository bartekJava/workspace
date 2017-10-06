package pl.altkom.hibernatejpa.service;

import java.time.LocalDate;
import java.util.List;

import pl.altkom.hibernatejpa.model.Borrower;

public interface BorrowerService {
	
	Borrower findById(long id);
    
    Borrower saveBorrower(Borrower borrower);
     
    void updateBorrower(Borrower borrower);
     
    void deleteBorrowerBySsn(String ssn);
 
    List<Borrower> findAllBorrowers(); 
     
    Borrower findBorrowerBySsn(String ssn);
 
    boolean isBorrowerSsnUnique(Long id, String ssn);
    
    List<Borrower> findByReturnDate(LocalDate returnDate);
    
    void test();

	boolean isBorrowerExist(Borrower borrower);

	void deleteById(long id);
	
	void deleteAllBorrowers();

}
