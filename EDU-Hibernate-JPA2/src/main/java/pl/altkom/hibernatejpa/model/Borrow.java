package pl.altkom.hibernatejpa.model;

import java.time.LocalDate;

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

@Entity
public class Borrow {
	
	@Id
	//@GeneratedValue(generator = "ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @Column(name="BORROW_DATE", nullable=false)
	private LocalDate borrowDate;
	
	@NotNull
    @Column(name="RETURN_DATE", nullable=false)
	private LocalDate returnDate;
	
	@ManyToOne(fetch = FetchType.LAZY) // Defaults to EAGER
	@JoinColumn(name = "BORROWER_ID", nullable = false)
	private Borrower borrower;
	
	//one-to-one with join table; the ITEM_ID column in join table ITEM_BORROW is unique
	//therefore an item can be in only one borrow
	@OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ITEM_BORROW",
        joinColumns =
            @JoinColumn(name = "BORROW_ID"),
        inverseJoinColumns =
            @JoinColumn(name = "ITEM_ID",
                        nullable = false,
                        unique = true)
    )
	private Item item;

	
	
	public Borrow() {}

	public Borrow(LocalDate borrowDate, LocalDate returnDate, Borrower borrower, Item item) {
		super();
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.borrower = borrower;
		this.item = item;
	}

	
	
	public long getId() {
		return id;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Borrow)) {
			return false;
		}

		Borrow other = (Borrow) o;

		return other.borrowDate.equals(borrowDate) && 
				other.returnDate.equals(returnDate) &&
				other.borrower.equals(borrower) &&
				other.item.equals(item);
	}

	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + borrowDate.hashCode();
        result = 31 * result + returnDate.hashCode();
        result = 31 * result + borrower.hashCode();
        result = 31 * result + item.hashCode();
        return result;
    }

}
