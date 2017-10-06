package pl.altkom.hibernatejpa.repositories;

import java.time.LocalDate;
import java.util.List;

import pl.altkom.hibernatejpa.model.Borrower;

public interface BorrowerRepositoryCustom {
	
	public List<Borrower> findByQuery(LocalDate returnDate);

}
