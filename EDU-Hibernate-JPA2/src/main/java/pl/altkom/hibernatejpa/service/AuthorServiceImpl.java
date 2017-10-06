package pl.altkom.hibernatejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.altkom.hibernatejpa.model.Author;
import pl.altkom.hibernatejpa.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	public Author findById(long id) {
		return authorRepository.findOne(id);
	}

	public Author findByLastName(String lastName) {
		return authorRepository.findByLastName(lastName);
	}

	public Author save(Author author) {
		authorRepository.save(author);
		return author;
	}

	public void update(Author author) {
		save(author);
	}

	public void deleteById(long id) {
		authorRepository.delete(id);
	}

	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public boolean isAuthorExist(Author author) {
		return authorRepository.findByFullName(author.getFirstName(), author.getLastName()) != null;
	}

	@Override
	public void deleteAllAuthors() {
		authorRepository.deleteAll();
	}

}
