package pl.altkom.hibernatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.hibernatejpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByTitle(String title);
	
	Book findByIsbnNumber(String isbn);
	
	void deleteByIsbnNumber(String isbn);
	
}
