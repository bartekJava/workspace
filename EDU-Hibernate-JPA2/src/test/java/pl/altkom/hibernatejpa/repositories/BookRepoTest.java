//package pl.altkom.hibernatejpa.repositories;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Set;
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
//import pl.altkom.hibernatejpa.model.Genre;
//import pl.altkom.hibernatejpa.service.BorrowService;
//
//
//public class BookRepoTest {
//	@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//	@DirtiesContext
//	public class RepositoriesEmptyDataTest extends AbstractTransactionalTestNGSpringContextTests {
//		
//		@Autowired
//		private BookRepository bookRepository;
//		
//		@Autowired
//		private AuthorRepository authorRepository;
//		
//		@Autowired
//		private GenreRepository genreRepository;
//		
//		@Autowired
//		private BorrowRepository borrowRepository;
//		
//		@Autowired
//		private BorrowerRepository borrowerRepository;
//		
//		@Autowired
//		private BorrowService borrowService;
//		
//		@Test
//		public void getAuthor() {
//			Author author = authorRepository.findByLastName("Suleiman");
//			Assert.assertEquals(author.getId(), 1L);
//
//		}
//		
//		@Test
//		public void getGenre() {
//			Genre genre = genreRepository.findOne(2L);
//			Assert.assertEquals(genre.getType(), "Tragedy");
//
//		}
//		
//		@Test
//		public void getBook() {
//			Book book = bookRepository.getOne(1L);
//			Author author = book.getAuthor();
//			Set<Genre> genres = book.getGenres();
//			
//			Assert.assertEquals(author.getLastName(), "Suleiman");
//			Assert.assertEquals(genres.size(), 2);
//			
//		}
//		
//		@Test
//		public void getBook2() {
//			Book book = bookRepository.getOne(2L);
//			Author author = book.getAuthor();
//			Set<Genre> genres = book.getGenres();
//			
//			Assert.assertEquals(author.getLastName(), "Bauer");
//			Assert.assertEquals(genres.size(), 3);
//			
//		}
//		
//		@Test
//		public void getBorrow() {
//			Borrow borrow = borrowRepository.getOne(2L);
//			Borrower borrower = borrow.getBorrower();
//			LocalDate borrowDate = borrow.getBorrowDate();
//			LocalDate returnDate = borrow.getReturnDate();
//			String title = borrow.getBook().getTitle();
//			
//			Assert.assertEquals(borrower.getFirstName(), "Rose");
//			Assert.assertEquals(borrowDate, LocalDate.of(2017, 6, 3));
//			Assert.assertEquals(returnDate, LocalDate.of(2017, 6, 18));
//			Assert.assertEquals(title, "Just Hibernate");
//			
//		}
//		
////		@Test
////		public void getBorrows() {
////			Borrower borrower = borrowerRepository.findOne(4L);
////			
////			Assert.assertEquals(borrower.getBorrows().size(), 2);
////			
////		}
//		
//		@Test
//		public void getBorrowsService() {
//			borrowService.findAllBorrows();
//			
//			Assert.assertEquals(true, true);
//		}
//		
//		@Test
//		public void getBorrowsRepo() {
//			List<Borrow> borrows = borrowRepository.findAll();
//			
//			Assert.assertEquals(borrows.size(), 3);
//		}
//		
//	}
//
//}
