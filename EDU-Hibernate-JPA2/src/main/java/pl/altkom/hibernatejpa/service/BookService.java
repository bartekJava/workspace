package pl.altkom.hibernatejpa.service;

import java.util.List;

import pl.altkom.hibernatejpa.model.Book;

public interface BookService {
	
	Book findById(long id);
	
    Book findByTitle(String title);
    
    Book save(Book book);
     
    void update(Book book);
    
    void deleteById(long id);
     
    void deleteByISBN(String isbn);
    
    void deleteAllBooks();
 
    List<Book> findAllBooks();
    
    boolean isBookExist(Book book);
     
}
