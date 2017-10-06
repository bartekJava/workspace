package pl.altkom.hibernatejpa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOK_ID")
	private long id;
	
	@NotNull
	@Column(name="ISBN_NUMBER", unique = true)
	private String isbnNumber;
	
	@NotNull
	@Column(name="BOOK_TITLE")
	private String title;

	@NotNull
	@ManyToOne(optional = false)
    @JoinColumn(name="AUTHOR_ID")
	private Author author;
	
	@NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_GENRE", 
             joinColumns = { @JoinColumn(name = "BOOK_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "GENRE_ID") })
	private Set<Genre> genres = new HashSet<>();
	
	@NotNull
	@Column(name="PAGE_COUNT")
	private int pageCount;
	
	@NotNull
    @Column(name="PUBLISH_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
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
				other.publishDate.equals(publishDate) &&
				other.getIsbnNumber().equals(getIsbnNumber());
	}

	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getPublishDate().hashCode();
        result = 31 * result + getIsbnNumber().hashCode();
        return result;
    }

}
