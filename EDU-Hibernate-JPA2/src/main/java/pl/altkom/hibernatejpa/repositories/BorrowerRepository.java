package pl.altkom.hibernatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.hibernatejpa.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long>{
	
	Borrower findByFirstName(String firstName);
	
	void deleteBySsn(String ssn);
	
}
