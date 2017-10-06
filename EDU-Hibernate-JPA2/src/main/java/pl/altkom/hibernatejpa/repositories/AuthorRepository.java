package pl.altkom.hibernatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.altkom.hibernatejpa.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom{

	Author findByLastName(String lastName);
	
}
