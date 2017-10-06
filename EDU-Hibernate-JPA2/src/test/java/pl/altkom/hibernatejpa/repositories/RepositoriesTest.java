//package pl.altkom.hibernatejpa.repositories;
//
//import java.time.LocalDate;
//import java.time.Year;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.xml.FlatXmlDataSet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import pl.altkom.hibernatejpa.model.Author;
//import pl.altkom.hibernatejpa.model.Book;
//import pl.altkom.hibernatejpa.model.Borrow;
//import pl.altkom.hibernatejpa.model.Borrower;
//
//public class RepositoriesTest extends EntityRepositoryTest {
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
//	@Autowired
//	private AuthorRepository authorRepository;
//	
//	@Autowired
//	EntityManager entityManager;
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
//    public void saveBorrowInsert(){	
//		Borrower borrower = new Borrower();
//		borrower = borrowerRepository.findOne(1L);
//		Assert.assertEquals(borrower.getSsn(), "70010100111");
//		
//		Book book = new Book();
//		book = bookRepository.findOne(1L);
//		Assert.assertEquals(book.getTitle(), "Java Persistence with Hibernate");
//		
//		Set<Author> authors = new HashSet<>();
//		authors = book.getAuthors();
//		Assert.assertEquals(authors.size(), 2);
//		
//		Borrow borrow = new Borrow();
//		borrow.setBorrowDate(LocalDate.of(2017, 5, 3));
//		borrow.setReturnDate(LocalDate.of(2017, 5, 24));
//		borrow.setBorrower(borrower);
//		borrow.setItem(book);
//		
//		borrowRepository.save(borrow);
//		Assert.assertNotNull(borrowRepository.findAll());
//		
//		List<Borrow> borrows = borrowRepository.findByBorrower(borrower);
//		Assert.assertEquals(borrows.isEmpty(), false);
//    }
//	
//	
//	@Test(dataProvider = "test1")
//    public void saveBorrowWithParameters(String firstName, String lastName, String isbn) {
//		Author author1 = new Author(firstName, lastName);
//		Author author2 = new Author("Gavin", "King");
//		Set<Author> authors = new HashSet<>();
//		authors.add(author1);
//		authors.add(author2);
//		
//		Book book = new Book();
//		book.setTitle("Java Persistence with Hibernate");
//		book.setIsbnNumber(isbn);
//		book.setAuthors(authors);
//		book.setPublishYear(Year.of(2016));
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
//
//    }
//	
//	@Test
//	public void fetchAuthor() {
//		String lastName = "King";
//		
//		TypedQuery<Author> query = entityManager.createQuery(
//				"select a from Author a where a.lastName = :lastName", Author.class
//				).setParameter("lastName", lastName);
//		
//		Author result = query.getSingleResult();
//		
//		Assert.assertEquals(result.getFirstName(), "Gavin");
//	}
//	
//	@Test
//	public void fetchBook() {
//		long ITEM_ID = 1L;
//		
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Book> criteria = cb.createQuery(Book.class);
//		Root<Book> b = criteria.from(Book.class);
//		criteria.select(b).where(cb.equal(b.get("id"), ITEM_ID));
//		
//		TypedQuery<Book> query = entityManager.createQuery(criteria);
//		Book result = query.getSingleResult();
//		
//		Assert.assertEquals(result.getTitle(), "Java Persistence with Hibernate");
//	}
//	
//	@Test
//	public void fetchBookWithJoin() {
//		String lastName = "Konda";
//		
//		TypedQuery<Book> query = entityManager.createQuery(
//				"select b from Book b join b.authors a where a.lastName = :lastName", Book.class
//				).setParameter("lastName", lastName);
//		
//		List<Book> results = query.getResultList();
//		
//		Assert.assertEquals(results.size(), 1);
//	}
//	
//	@DataProvider(name = "test1")
//	public Object[][] createData1() {
//	 return new Object[][] {
//	   { "Christian", "Bauer", "9781932394888" },
//	   {  "Joshua", "Bloch", "9781932394889" }
//	 };
//	}
//
//}
