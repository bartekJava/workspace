package pl.altkom.hibernatejpa.service;

import java.util.List;

import pl.altkom.hibernatejpa.model.Author;

public interface AuthorService {
	
	Author findById(long id);
	
	Author findByLastName(String lastName);
    
	Author save(Author author);
     
    void update(Author author);
     
    void deleteById(long id);
    
    void deleteAllAuthors();
 
    List<Author> findAllAuthors();

	boolean isAuthorExist(Author author);

}
