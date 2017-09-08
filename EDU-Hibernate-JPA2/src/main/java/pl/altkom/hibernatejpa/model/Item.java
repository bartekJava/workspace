package pl.altkom.hibernatejpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Item {
	
	@Id
	//@GeneratedValue(generator = "ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private long id;
	
	@NotNull
    @Column(name="TITLE", nullable=false)
	private String title;
	
	//this boolean maps to a CHAR column with values Y or N.
	@Type(type = "yes_no")
	private boolean availible = true;
	
	@NotNull
    @Column(name="ISBN", nullable=false)
	private String isbnNumber;
	
	

	public Item() {}

	public Item(String title, String isbnNumber) {
		this.title = title;
		this.isbnNumber = isbnNumber;
	}

	
	
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvailible() {
		return availible;
	}

	public void setAvailible(boolean availible) {
		this.availible = availible;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	
	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Item)) {
			return false;
		}

		Item other = (Item) o;

		return other.isbnNumber.equals(isbnNumber);
	}
	
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + isbnNumber.hashCode();
        
        return result;
    }
	
}
