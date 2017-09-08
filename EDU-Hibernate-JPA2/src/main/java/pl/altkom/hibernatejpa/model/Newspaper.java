package pl.altkom.hibernatejpa.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name="ITEM_ID")
public class Newspaper extends Item {

	@NotNull
    @Column(name="PUBLISH_DATE", nullable=false)
	private LocalDateTime publishDate;

	
	
	public Newspaper() {}

	public Newspaper(String title, String isbnNumber, LocalDateTime publishDate) {
		super(title, isbnNumber);
		this.publishDate = publishDate;
	}

	
	
	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}
	
	
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Newspaper)) {
			return false;
		}

		Newspaper other = (Newspaper) o;

		return other.getTitle().equals(getTitle()) && 
				other.getPublishDate().equals(publishDate) &&
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
