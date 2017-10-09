//package pl.altkom.hibernatejpa.repositories;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.xml.FlatXmlDataSet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import pl.altkom.hibernatejpa.model.Author;
//import pl.altkom.hibernatejpa.model.Book;
//import pl.altkom.hibernatejpa.model.Borrow;
//import pl.altkom.hibernatejpa.model.Borrower;
//
//public class BorrowRepositoryTest extends EntityRepositoryTest {
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
//	
//	
//	@Override
//	protected IDataSet getDataSet() throws Exception {
//		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Borrow.xml"));
//        return dataSet;
//	}
//	
//	
//	
//	@Test
//    public void saveBorrow(){
//		Author author1 = new Author("Christian", "Bauer");
//		Author author2 = new Author("Gavin", "King");
//		Set<Author> authors = new HashSet<>();
//		authors.add(author1);
//		authors.add(author2);
//		
//		Book book = new Book();
//		book.setTitle("Java Persistence with Hibernate");
//		book.setIsbnNumber("9781932394887");
//		book.setAuthors(authors);
//		book.setPublishYear(LocalDate.of(2006, 10, 1));
//		Book savedBook = bookRepository.save(book);
//		
//		Borrower borrower = new Borrower();
//		borrower.setFirstName("Name");
//		borrower.setLastName("Lastname");
//		borrower.setSsn("90030300333");
//		Borrower savedBorrower = borrowerRepository.save(borrower);
//		
//		Borrow borrow = new Borrow();
//		borrow.setBorrowDate(LocalDate.of(2017, 5, 3));
//		borrow.setReturnDate(LocalDate.of(2017, 5, 24));
//		borrow.setBorrower(savedBorrower);
//		borrow.setItem(savedBook);
//		
//		borrowRepository.save(borrow);
//		Assert.assertNotNull(borrowRepository.findAll());
//    }
//	
//	
//	
//	/*public Borrow getSampleBorrow() {
//		Borrow borrow = new Borrow();
//		
//		Borrower borrower = new Borrower();
//		borrower.setFirstName("Name");
//		borrower.setLastName("Lastname");
//		borrower.setSsn("90030300333");
//		
//		Author author1 = new Author("Christian", "Bauer");
//		Author author2 = new Author("Gavin", "King");
//		
//		Set<Author> authors = new HashSet<>();
//		authors.add(author1);
//		authors.add(author2);
//		
//		Book book = new Book();
//		book.setTitle("Java Persistence with Hibernate");
//		book.setIsbnNumber("9781932394887");
//		book.setAuthors(authors);
//		book.setPublishYear(LocalDate.of(2006, 10, 1));
//		
//		borrow.setBorrowDate(LocalDate.of(2017, 5, 3));
//		borrow.setReturnDate(LocalDate.of(2017, 5, 24));
//		borrow.setBorrower(borrower);
//		borrow.setItem(book);
//		
//		return borrow;
//	}*/
//
//}
