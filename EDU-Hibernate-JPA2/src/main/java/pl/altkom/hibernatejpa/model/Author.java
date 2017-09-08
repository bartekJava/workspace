package pl.altkom.hibernatejpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Author {

	@Id
	//@GeneratedValue(generator = "ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@NotNull
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "AUTHOR_ITEM", joinColumns = @JoinColumn(name = "AUTHOR_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private Set<Book> books = new HashSet<>();

	
	
	public Author() {
	}

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Author)) {
			return false;
		}

		Author other = (Author) o;

		return other.firstName.equals(firstName) && other.lastName.equals(lastName);
	}

	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

}
