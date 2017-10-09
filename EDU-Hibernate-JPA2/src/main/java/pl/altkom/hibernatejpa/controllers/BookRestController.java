package pl.altkom.hibernatejpa.controllers;

import java.util.List;

import javax.validation.Valid;

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

import pl.altkom.hibernatejpa.model.Book;
import pl.altkom.hibernatejpa.service.BookService;

@RestController
@CrossOrigin
public class BookRestController {

	@Autowired
	BookService bookService;
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "REST";
    }

	
	@RequestMapping(value = "/book/", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllBooks() {
		List<Book> books = bookService.findAllBooks();

		if (books.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
		Book book = bookService.findById(id);

		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/book/title/{regex}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getBookByTitleRegex(@PathVariable("regex") String regex) {
		List<Book> books = bookService.findByTitleRegex(regex);

		if (books.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/book/", method = RequestMethod.POST)
	public ResponseEntity<Void> createBook(@Valid @RequestBody Book book, UriComponentsBuilder ucBuilder) {
//		if (bookService.isBookExist(book)) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}

		bookService.save(book);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
		Book currentBook = bookService.findById(id);

		if (currentBook == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		currentBook.setTitle(book.getTitle());
		currentBook.setIsbnNumber(book.getIsbnNumber());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setPublishDate(book.getPublishDate());
		currentBook.setGenres(book.getGenres());
		currentBook.setPageCount(book.getPageCount());

		bookService.update(currentBook);
		return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
 
        bookService.deleteById(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
	
	
	
	@RequestMapping(value = "/book/", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteAllBooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }

}
