package pl.altkom.hibernatejpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GENRE_ID")
	private long id;
	
	@Column(name="TYPE", unique=true, nullable=false)
    private String type = GenreType.DRAMA.getGenreType();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		int result = 17;
        result = 31 * result + type.hashCode();
        return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Borrower)) {
			return false;
		}

		Genre other = (Genre) o;

		return other.type.equals(type);
	}
	
}
