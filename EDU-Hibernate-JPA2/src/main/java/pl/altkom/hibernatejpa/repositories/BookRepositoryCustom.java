package pl.altkom.hibernatejpa.repositories;

import java.util.List;

import pl.altkom.hibernatejpa.model.Book;

public interface BookRepositoryCustom {
	
	public List<Book> findByTitleRegex(String regex);
	
//	Spring Data JPA: List<User> findByTitleContainingIgnoreCase(String name);

}
