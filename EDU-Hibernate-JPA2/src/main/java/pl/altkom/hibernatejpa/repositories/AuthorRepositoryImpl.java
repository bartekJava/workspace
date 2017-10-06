package pl.altkom.hibernatejpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import pl.altkom.hibernatejpa.model.Author;

public class AuthorRepositoryImpl implements AuthorRepositoryCustom{
	
	@Autowired
	EntityManager entityManager;

	
	@Override
	public Author findByFullName(String firstName, String lastName) {
		TypedQuery<Author> query = entityManager.createQuery(
				"select a from Author a where a.firstName = :firstName and a.lastName = :lastName", Author.class
				).setParameter("firstName", firstName).setParameter("lastName", lastName);
		return null;
	}

}
