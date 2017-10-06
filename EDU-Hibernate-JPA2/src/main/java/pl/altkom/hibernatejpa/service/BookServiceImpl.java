package pl.altkom.hibernatejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.altkom.hibernatejpa.model.Book;
import pl.altkom.hibernatejpa.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public Book findById(long id) {
		return bookRepository.findOne(id);
	}

	public Book findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	public Book save(Book book) {
		bookRepository.save(book);
		return book;
	}

	public void update(Book book) {
		save(book);
	}

	public void deleteByISBN(String isbn) {
		bookRepository.deleteByIsbnNumber(isbn);
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public boolean isBookExist(Book book) {
		return bookRepository.findByIsbnNumber(book.getIsbnNumber()) != null;
	}

	public void deleteById(long id) {
		bookRepository.delete(id);
		
	}

	public void deleteAllBooks() {
		bookRepository.deleteAll();
		
	}

}
