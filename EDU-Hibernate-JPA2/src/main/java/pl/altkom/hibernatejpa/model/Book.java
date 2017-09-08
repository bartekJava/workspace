package pl.altkom.hibernatejpa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

/**This entity has no identifier property; it automatically inherits the ID property and 
column from the superclass*/
@Entity
@PrimaryKeyJoinColumn(name="ITEM_ID")
public class Book extends Item {

	@ManyToMany(mappedBy = "books")
	private Set<Author> authors = new HashSet<>();
	
	@NotNull
    @Column(name="PUBLISH_YEAR", nullable=false)
	private LocalDate publishYear;
	
	@Lob
	private byte[] coverImage;
	
	

	public Book() {}

	public Book(String title, String isbnNumber, Set<Author> authors, LocalDate publishYear) {
		super(title, isbnNumber);
		this.authors = authors;
		this.publishYear = publishYear;
	}

	
	
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public LocalDate getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(LocalDate publishYear) {
		this.publishYear = publishYear;
	}

	public byte[] getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}
	
	
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Book)) {
			return false;
		}

		Book other = (Book) o;

		return other.getTitle().equals(getTitle()) && 
				other.publishYear.equals(publishYear) &&
				other.getIsbnNumber().equals(getIsbnNumber());
	}

	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getPublishYear().hashCode();
        result = 31 * result + getIsbnNumber().hashCode();
        return result;
    }

}
