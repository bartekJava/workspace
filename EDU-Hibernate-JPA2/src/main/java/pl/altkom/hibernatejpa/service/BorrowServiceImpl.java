package pl.altkom.hibernatejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.altkom.hibernatejpa.model.Book;
import pl.altkom.hibernatejpa.model.Borrow;
import pl.altkom.hibernatejpa.model.Borrower;
import pl.altkom.hibernatejpa.repositories.BorrowRepository;

@Service
public class BorrowServiceImpl implements BorrowService{

	@Autowired
	private BorrowRepository borrowRepository;
	
	public Borrow findById(long id) {
		return borrowRepository.findOne(id);
	}

	public List<Borrow> findByBorrower(Borrower borrower) {
		return borrowRepository.findByBorrower(borrower);
	}

	public Borrow save(Borrow borrow) {
		return borrowRepository.save(borrow);
	}

	public void update(Borrow borrow) {
		save(borrow);
	}

	public void deleteById(long id) {
		borrowRepository.delete(id);
	}

	public List<Borrow> findAllBorrows() {
		return borrowRepository.findAll();
	}

	public boolean isBorrowExist(Borrow borrow) {
		return borrowRepository.findOne(borrow.getId()) != null;
	}

	public void deleteAllBorrows() {
		borrowRepository.deleteAll();
	}

	@Override
	public Borrow findByBook(Book book) {
		return borrowRepository.findByBook(book);
	}

	@Override
	public Borrow findByBookId(long id) {
		return borrowRepository.findByBookId(id);
	}

}
