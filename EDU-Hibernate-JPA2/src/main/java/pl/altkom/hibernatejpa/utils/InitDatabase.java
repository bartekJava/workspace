package pl.altkom.hibernatejpa.utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.altkom.hibernatejpa.model.Author;
import pl.altkom.hibernatejpa.model.Book;
import pl.altkom.hibernatejpa.model.Borrow;
import pl.altkom.hibernatejpa.model.Borrower;
import pl.altkom.hibernatejpa.model.Genre;
import pl.altkom.hibernatejpa.model.GenreType;
import pl.altkom.hibernatejpa.repositories.AuthorRepository;
import pl.altkom.hibernatejpa.repositories.BookRepository;
import pl.altkom.hibernatejpa.repositories.BorrowRepository;
import pl.altkom.hibernatejpa.repositories.BorrowerRepository;
import pl.altkom.hibernatejpa.repositories.GenreRepository;

@Component
public class InitDatabase {
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	@Autowired
	public InitDatabase(BorrowRepository borrowRepository, BookRepository bookRepository,
			BorrowerRepository borrowerRepository, AuthorRepository authorRepository, 
			GenreRepository genreRepository) {
		
		this.borrowRepository = borrowRepository;
		this.bookRepository = bookRepository;
		this.borrowerRepository = borrowerRepository;
		this.authorRepository = authorRepository;
		this.genreRepository = genreRepository;
		
		saveBook();
	}
	
	private Author author_1 = new Author();
	private Author author_2 = new Author();
	private Author author_3 = new Author();
	private Author author_4 = new Author();
	private Author author_5 = new Author();
	private Author author_6 = new Author();
	
	private Genre genre_1 = new Genre();
	private Genre genre_2 = new Genre();
	private Genre genre_3 = new Genre();
	private Genre genre_4 = new Genre();
	private Genre genre_5 = new Genre();
	private Genre genre_6 = new Genre();
	private Genre genre_7 = new Genre();
	
	private Set<Genre> genres_1 = new HashSet<>();
	private Set<Genre> genres_2 = new HashSet<>();
	private Set<Genre> genres_3 = new HashSet<>();
	private Set<Genre> genres_4 = new HashSet<>();
	private Set<Genre> genres_5 = new HashSet<>();
	private Set<Genre> genres_6 = new HashSet<>();
	
	private Book book_1 = new Book();
	private Book book_2 = new Book();
	private Book book_3 = new Book();
	private Book book_4 = new Book();
	private Book book_5 = new Book();
	private Book book_6 = new Book();
	
	private Borrow borrow_1 = new Borrow();
	private Borrow borrow_2 = new Borrow();
	private Borrow borrow_3 = new Borrow();
	
	private Set<Borrow> borrows_1 = new HashSet<>();
	
	private Borrower borrower_1 = new Borrower();
	private Borrower borrower_2 = new Borrower();
	private Borrower borrower_3 = new Borrower();
	private Borrower borrower_4 = new Borrower();
	private Borrower borrower_5 = new Borrower();
	private Borrower borrower_6 = new Borrower();
	private Borrower borrower_7 = new Borrower();
	private Borrower borrower_8 = new Borrower();
	private Borrower borrower_9 = new Borrower();

	
	public void saveBook() {
		
		author_1.setFirstName("Hani");
		author_1.setLastName("Suleiman");
		authorRepository.save(author_1);
		
		author_2.setFirstName("Christian");
		author_2.setLastName("Bauer");
		authorRepository.save(author_2);
		
		author_3.setFirstName("Madhusudhan");
		author_3.setLastName("Konda");
		authorRepository.save(author_3);
		
		author_4.setFirstName("Joshua");
		author_4.setLastName("Bloch");
		authorRepository.save(author_4);
		
		author_5.setFirstName("Craig");
		author_5.setLastName("Walls");
		authorRepository.save(author_5);
		
		author_6.setFirstName("Venkat");
		author_6.setLastName("Subramaniam");
		authorRepository.save(author_6);
		
		
		
		genre_1.setType(GenreType.DRAMA.getGenreType());
		genreRepository.save(genre_1);
		genre_2.setType(GenreType.TRAGEDY.getGenreType());
		genreRepository.save(genre_2);
		genre_3.setType(GenreType.COMEDY.getGenreType());
		genreRepository.save(genre_3);
		genre_4.setType(GenreType.HORROR.getGenreType());
		genreRepository.save(genre_4);
		genre_5.setType(GenreType.SATIRE.getGenreType());
		genreRepository.save(genre_5);
		genre_6.setType(GenreType.TRAGICOMEDY.getGenreType());
		genreRepository.save(genre_6);
		genre_7.setType(GenreType.FANTASY.getGenreType());
		genreRepository.save(genre_7);
		
		
		
		genres_1.add(genre_1);
		genres_1.add(genre_2);
		
		genres_2.add(genre_4);
		genres_2.add(genre_2);
		genres_2.add(genre_6);
		
		genres_3.add(genre_5);
		genres_3.add(genre_2);

		genres_4.add(genre_2);
		genres_4.add(genre_7);
		genres_4.add(genre_1);
		genres_4.add(genre_6);
		
		genres_5.add(genre_4);
		genres_5.add(genre_3);
		
		genres_6.add(genre_1);
		genres_6.add(genre_2);
		genres_6.add(genre_3);
		genres_6.add(genre_4);

		
		
		book_1.setIsbnNumber("978-3-16-148410-0");
		book_1.setTitle("Next Generation Java Testing");
		book_1.setAuthor(author_1);
		book_1.setGenres(genres_1);
		book_1.setPageCount(521);
		book_1.setPublishDate(LocalDate.of(2007, 9, 16));
		bookRepository.save(book_1);
		
		book_2.setIsbnNumber("278-3-56-1457610-1");
		book_2.setTitle("Java Persistence with Hibernate");
		book_2.setAuthor(author_2);
		book_2.setGenres(genres_2);
		book_2.setPageCount(625);
		book_2.setPublishDate(LocalDate.of(2006, 1, 1));
		bookRepository.save(book_2);
		
		book_3.setIsbnNumber("456-3-56-1434610-6");
		book_3.setTitle("Just Hibernate");
		book_3.setAuthor(author_3);
		book_3.setGenres(genres_3);
		book_3.setPageCount(234);
		book_3.setPublishDate(LocalDate.of(2005, 4, 12));
		bookRepository.save(book_3);
		
		book_4.setIsbnNumber("347-3-56-1456710-2");
		book_4.setTitle("Effective Java");
		book_4.setAuthor(author_4);
		book_4.setGenres(genres_4);
		book_4.setPageCount(234);
		book_4.setPublishDate(LocalDate.of(2011, 5, 27));
		bookRepository.save(book_4);
		
		book_5.setIsbnNumber("678-3-56-1476710-4");
		book_5.setTitle("Spring in Action");
		book_5.setAuthor(author_5);
		book_5.setGenres(genres_5);
		book_5.setPageCount(756);
		book_5.setPublishDate(LocalDate.of(2013, 9, 3));
		bookRepository.save(book_5);
		
		book_6.setIsbnNumber("566-3-56-1473420-7");
		book_6.setTitle("Functional Programming in Java");
		book_6.setAuthor(author_6);
		book_6.setGenres(genres_6);
		book_6.setPageCount(245);
		book_6.setPublishDate(LocalDate.of(2016, 2, 28));
		bookRepository.save(book_6);
		
		
		
		borrower_1.setFirstName("John");
		borrower_1.setLastName("Doe");
		borrower_1.setSsn("70010100111");
		borrowerRepository.save(borrower_1);
//		borrower_1.setBorrows(borrows_1);
		
		borrower_2.setFirstName("Andrew");
		borrower_2.setLastName("Shoulders");
		borrower_2.setSsn("43510100111");
		borrowerRepository.save(borrower_2);
		
		borrower_3.setFirstName("William");
		borrower_3.setLastName("Sheppard");
		borrower_3.setSsn("23510100111");
		borrowerRepository.save(borrower_3);
		
		borrower_4.setFirstName("Rose");
		borrower_4.setLastName("Johnson");
		borrower_4.setSsn("12310100111");
		borrowerRepository.save(borrower_4);
		
		borrower_5.setFirstName("Darryl");
		borrower_5.setLastName("Etheridge");
		borrower_5.setSsn("56710100111");
		borrowerRepository.save(borrower_5);
		
		borrower_6.setFirstName("Harold");
		borrower_6.setLastName("Hardy");
		borrower_6.setSsn("54310100111");
		borrowerRepository.save(borrower_6);
		
		borrower_7.setFirstName("Sally");
		borrower_7.setLastName("Schultz");
		borrower_7.setSsn("75610100111");
		borrowerRepository.save(borrower_7);
		
		borrower_8.setFirstName("Timmy");
		borrower_8.setLastName("Jaynes");
		borrower_8.setSsn("97810100111");
		borrowerRepository.save(borrower_8);
		
		borrower_9.setFirstName("Mariana");
		borrower_9.setLastName("Sherman");
		borrower_9.setSsn("42210100111");
		borrowerRepository.save(borrower_9);
				
		
		
//		borrow_1.setBorrowDate(LocalDate.of(2017, 5, 1));
//		borrow_1.setReturnDate(LocalDate.of(2017, 5, 15));
		borrow_1.setBook(book_1);
		borrow_1.setBorrower(borrower_1);
		borrowRepository.save(borrow_1);
		
//		borrow_2.setBorrowDate(LocalDate.of(2017, 6, 3));
//		borrow_2.setReturnDate(LocalDate.of(2017, 6, 18));
		borrow_2.setBook(book_3);
		borrow_2.setBorrower(borrower_4);
		borrowRepository.save(borrow_2);
		
//		borrow_3.setBorrowDate(LocalDate.of(2017, 8, 5));
//		borrow_3.setReturnDate(LocalDate.of(2017, 8, 20));
		borrow_3.setBook(book_5);
		borrow_3.setBorrower(borrower_4);
		borrowRepository.save(borrow_3);
		
//		borrows_1.add(borrow_1);
	
	}



	public void saveBorrow() {
//		Author author1 = new Author("Srgsdg", "Hjdhjtyjd");
//		Author author2 = new Author("Gavin", "King");
//		Set<Author> authors = new HashSet<>();
//		authors.add(author1);
//		authors.add(author2);
//		
//		Book book = new Book();
//		book.setTitle("Java Persistence with Hibernate");
//		book.setIsbnNumber("9781932394887");
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
    }

}
