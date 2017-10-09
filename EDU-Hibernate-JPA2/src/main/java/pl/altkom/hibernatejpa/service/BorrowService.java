package pl.altkom.hibernatejpa.service;

import java.util.List;

import pl.altkom.hibernatejpa.model.Borrow;
import pl.altkom.hibernatejpa.model.Borrower;

public interface BorrowService {
	
	Borrow findById(long id);
	
	List<Borrow> findByBorrower(Borrower borrower);
    
	Borrow save(Borrow borrow);
     
    void update(Borrow borrow);
     
    void deleteById(long id);
 
    List<Borrow> findAllBorrows();

	boolean isBorrowExist(Borrow borrow);

	void deleteAllBorrows();
	
	Borrow findByBookId(long id);
	
}
