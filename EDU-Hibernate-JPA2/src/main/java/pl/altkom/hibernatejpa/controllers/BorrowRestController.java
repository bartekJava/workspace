package pl.altkom.hibernatejpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pl.altkom.hibernatejpa.model.Borrow;
import pl.altkom.hibernatejpa.service.BorrowService;

@RestController
@CrossOrigin
public class BorrowRestController {
	
	@Autowired
	BorrowService borrowService;
	
	
	@RequestMapping(value = "/borrow/", method = RequestMethod.GET)
	public ResponseEntity<List<Borrow>> listAllBorrows() {
		List<Borrow> borrows = borrowService.findAllBorrows();

		if (borrows.isEmpty()) {
			return new ResponseEntity<List<Borrow>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Borrow>>(borrows, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/borrow/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Borrow> getBorrow(@PathVariable("id") long id) {
		Borrow borrow = borrowService.findById(id);

		if (borrow == null) {
			return new ResponseEntity<Borrow>(HttpStatus.CONTINUE);
		}

		return new ResponseEntity<Borrow>(borrow, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/borrow/", method = RequestMethod.POST)
	public ResponseEntity<String> createBorrow(@RequestBody Borrow borrow, UriComponentsBuilder ucBuilder) {
		if (borrowService.isBorrowExist(borrow)) {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		
		List<Borrow> borrows = borrowService.findByBorrower(borrow.getBorrower());
		
		if (borrows.size() >= 3) {
			return new ResponseEntity<String>("Borrower can't have more than 3 borrows.", HttpStatus.CONFLICT);
		}
		
		borrowService.save(borrow);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/borrow/{id}").buildAndExpand(borrow.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	
	
	@RequestMapping(value = "/borrow/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Borrow> updateBorrow(@PathVariable("id") long id, @RequestBody Borrow borrow) {
		Borrow currentBorrow = borrowService.findById(id);

		if (currentBorrow == null) {
			return new ResponseEntity<Borrow>(HttpStatus.NOT_FOUND);
		}

//		currentBorrow.setBorrowDate(borrow.getBorrowDate());
//		currentBorrow.setReturnDate(borrow.getReturnDate());
		currentBorrow.setBorrower(borrow.getBorrower());

		borrowService.update(currentBorrow);
		return new ResponseEntity<Borrow>(currentBorrow, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/borrow/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Borrow> deleteBorrow(@PathVariable("id") long id) {
		Borrow borrow = borrowService.findById(id);
        if (borrow == null) {
            return new ResponseEntity<Borrow>(HttpStatus.NOT_FOUND);
        }
 
        borrowService.deleteById(id);
        return new ResponseEntity<Borrow>(HttpStatus.NO_CONTENT);
    }
	
	
	
	@RequestMapping(value = "/borrow/", method = RequestMethod.DELETE)
    public ResponseEntity<Borrow> deleteAllBorrows() {
		borrowService.deleteAllBorrows();
        return new ResponseEntity<Borrow>(HttpStatus.NO_CONTENT);
    }

}
