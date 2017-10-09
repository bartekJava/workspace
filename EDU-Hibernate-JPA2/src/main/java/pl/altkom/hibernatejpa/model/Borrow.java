package pl.altkom.hibernatejpa.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Borrow {
	
	@Id
	@Column(name="BORROW_ID")
	//@GeneratedValue(generator = "ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@NotNull
//    @Column(name="BORROW_DATE")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	private LocalDate borrowDate;
//	
//	@NotNull
//    @Column(name="RETURN_DATE")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	private LocalDate returnDate;
	
	@ManyToOne(fetch = FetchType.LAZY) // Defaults to EAGER
	@JoinColumn(name = "BORROWER_ID", nullable = false)
//	@JsonManagedReference
	private Borrower borrower;
	
	//one-to-one with join table; the ITEM_ID column in join table ITEM_BORROW is unique
	//therefore an item can be in only one borrow
	@OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "BOOK_BORROW",
        joinColumns =
            @JoinColumn(name = "BORROW_ID"),
        inverseJoinColumns =
            @JoinColumn(name = "BOOK_ID",
                        nullable = false,
                        unique = true)
    )
	private Book book;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public LocalDate getBorrowDate() {
//		return borrowDate;
//	}
//
//	public void setBorrowDate(LocalDate borrowDate) {
//		this.borrowDate = borrowDate;
//	}
//
//	public LocalDate getReturnDate() {
//		return returnDate;
//	}
//
//	public void setReturnDate(LocalDate returnDate) {
//		this.returnDate = returnDate;
//	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Borrow)) {
			return false;
		}

		Borrow other = (Borrow) o;

		return 	other.borrower.equals(borrower) &&
				other.book.equals(book);
	}

	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + borrower.hashCode();
        result = 31 * result + book.hashCode();
        return result;
    }

}
