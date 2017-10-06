package pl.altkom.hibernatejpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pl.altkom.hibernatejpa.model.Author;
import pl.altkom.hibernatejpa.service.AuthorService;

@RestController
@CrossOrigin
public class AuthorRestController {
	
	@Autowired
	AuthorService authorService;

	
	@RequestMapping(value = "/author/", method = RequestMethod.GET)
	public ResponseEntity<List<Author>> listAllAuthors() {
		List<Author> authors = authorService.findAllAuthors();

		if (authors.isEmpty()) {
			return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> getAuthor(@PathVariable("id") long id) {
		Author author = authorService.findById(id);

		if (author == null) {
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/author/", method = RequestMethod.POST)
	public ResponseEntity<Void> createAuthor(@RequestBody Author author, UriComponentsBuilder ucBuilder) {
		if (authorService.isAuthorExist(author)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		authorService.save(author);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/author/{id}").buildAndExpand(author.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	
	@RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id, @RequestBody Author author) {
		Author currentAuthor = authorService.findById(id);

		if (currentAuthor == null) {
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}

		currentAuthor.setFirstName(author.getFirstName());
		currentAuthor.setLastName(author.getLastName());

		authorService.update(currentAuthor);
		return new ResponseEntity<Author>(currentAuthor, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") long id) {
		Author author = authorService.findById(id);
        if (author == null) {
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }
 
        authorService.deleteById(id);
        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }
	
	
	
	@RequestMapping(value = "/author/", method = RequestMethod.DELETE)
    public ResponseEntity<Author> deleteAllAuthors() {
		authorService.deleteAllAuthors();
        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }

}
