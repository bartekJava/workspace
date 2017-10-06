package pl.altkom.hibernatejpa.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import pl.altkom.hibernatejpa.model.Borrower;

public class BorrowerRepositoryImpl implements BorrowerRepositoryCustom{

	@Autowired
	EntityManager entityManager;
	
	
	public List<Borrower> findByQuery(LocalDate returnDate) {
		TypedQuery<Borrower> query = entityManager.createQuery(
				"select b from Borrower b join b.borrows bb where bb.returnDate = :returnDate", Borrower.class
				).setParameter("returnDate", returnDate);
		
		query.setFirstResult(0);
		query.setMaxResults(10);
		
		List<Borrower> results = query.getResultList();
		
		return results;
	}
}
