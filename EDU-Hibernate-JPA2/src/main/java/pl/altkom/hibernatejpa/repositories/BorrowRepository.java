package pl.altkom.hibernatejpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.hibernatejpa.model.Book;
import pl.altkom.hibernatejpa.model.Borrow;
import pl.altkom.hibernatejpa.model.Borrower;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

	List<Borrow> findByBorrower(Borrower borrower);
	Borrow findByBook(Book book);
	Borrow findByBookId(long id);
}
