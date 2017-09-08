package pl.altkom.hibernatejpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Borrower {
	
	@Id
	//@GeneratedValue(generator = "ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@NotNull
    @Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@NotNull
    @Column(name="SSN", nullable=false)
    @Length(min = 11, max = 11)
	private String ssn;
	
	@Transient
	private String gender;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY)
	private Set<Borrow> borrows = new HashSet<>();

	
	
	public Borrower() {}

	public Borrower(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

	public long getId() {
		return id;
	}
	
	/*public void setId(long id) {
		this.id = id;
	}*/


	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Borrower)) {
			return false;
		}

		Borrower other = (Borrower) o;

		return other.firstName.equals(firstName) && 
				other.lastName.equals(lastName) &&
				other.ssn.equals(ssn);
	}

	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + ssn.hashCode();
        return result;
    }
	
}
