//package pl.altkom.hibernatejpa.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import pl.altkom.hibernatejpa.model.Borrower;
//
//@Service
//@Profile("production")
//public class BorrowerServiceImplProd implements BorrowerService {
//
//	@Override
//	public Borrower findById(long id) {
//		return getPredefinedBorrower();
//	}
//
//	@Override
//	public Borrower saveBorrower(Borrower borrower) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateBorrower(Borrower borrower) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteBorrowerBySsn(String ssn) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Borrower> findAllBorrowers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Borrower findBorrowerBySsn(String ssn) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isBorrowerSsnUnique(Long id, String ssn) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Borrower> findByReturnDate(LocalDate returnDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void test() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public Borrower getPredefinedBorrower() {
//		Borrower borrower = new Borrower();
//		borrower.setFirstName("Predefined FirstName");
//		borrower.setLastName("Predefined LastName");
//		borrower.setSsn("Predefined SSN");
//				
//		return borrower;
//	}
//
//}
