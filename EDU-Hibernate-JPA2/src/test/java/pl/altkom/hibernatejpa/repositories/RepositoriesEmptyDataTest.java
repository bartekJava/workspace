//package pl.altkom.hibernatejpa.repositories;
//
//import java.time.LocalDate;
//import java.time.Year;
//import java.util.HashSet;
//import java.util.Set;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import pl.altkom.hibernatejpa.model.Author;
//import pl.altkom.hibernatejpa.model.Book;
//import pl.altkom.hibernatejpa.model.Borrow;
//import pl.altkom.hibernatejpa.model.Borrower;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext
//public class RepositoriesEmptyDataTest extends AbstractTransactionalTestNGSpringContextTests {
//	
//	@Autowired
//	private BorrowRepository borrowRepository;
//	
//	@Autowired
//	private BookRepository bookRepository;
//	
//	@Autowired
//	private BorrowerRepository borrowerRepository;
//	
//	private AuthorRepository authorRepository;
//	
//	@Test
//	void saveAuthor() {
//		
//		Author author1 = new Author("Christian", "Bauer");
//		Author author2 = new Author("Gavin", "King");
//				
//		Book book1 = new Book();
//		book1.setTitle("Java Persistence with Hibernate");
//		book1.setIsbnNumber("978-1-449-33437-6");
//		book1.setPublishYear(Year.of(2016));
//		
//		Book book2 = new Book();
//		book2.setTitle("Just Hibernate");
//		book2.setIsbnNumber("9781932394887");
//		book2.setPublishYear(Year.of(2014));
//		
//		author1.getBooks().add(book1);
//		author2.getBooks().add(book1);
//		
//		book1.getAuthors().add(author1);
//		book1.getAuthors().add(author2);
//		
//		
//		authorRepository.save(author1);
//		
//		Assert.assertEquals(true, true);
//		
//	}
//	
//}
