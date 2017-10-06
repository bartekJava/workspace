package pl.altkom.hibernatejpa.repositories;

import pl.altkom.hibernatejpa.model.Author;

public interface AuthorRepositoryCustom {
	
	public Author findByFullName(String firstName, String lastName);

}
