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

import pl.altkom.hibernatejpa.model.Author;
import pl.altkom.hibernatejpa.model.Borrower;
import pl.altkom.hibernatejpa.service.AuthorService;
import pl.altkom.hibernatejpa.service.BorrowerService;

@RestController
@CrossOrigin
public class BorrowerRestController {
	
	@Autowired
	BorrowerService borrowerService;

	
	@RequestMapping(value = "/borrower/", method = RequestMethod.GET)
	public ResponseEntity<List<Borrower>> listAllBorrowers() {
		List<Borrower> borrowers = borrowerService.findAllBorrowers();

		if (borrowers.isEmpty()) {
			return new ResponseEntity<List<Borrower>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Borrower>>(borrowers, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/borrower/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Borrower> getBorrower(@PathVariable("id") long id) {
		Borrower borrower = borrowerService.findById(id);

		if (borrower == null) {
			return new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Borrower>(borrower, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/borrower/", method = RequestMethod.POST)
	public ResponseEntity<Void> createBorrower(@RequestBody Borrower borrower, UriComponentsBuilder ucBuilder) {
		if (borrowerService.isBorrowerExist(borrower)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		borrowerService.saveBorrower(borrower);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/borrower/{id}").buildAndExpand(borrower.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	
	@RequestMapping(value = "/borrower/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Borrower> updateBorrower(@PathVariable("id") long id, @RequestBody Borrower borrower) {
		Borrower currentBorrower = borrowerService.findById(id);

		if (currentBorrower == null) {
			return new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND);
		}

		currentBorrower.setFirstName(borrower.getFirstName());
		currentBorrower.setFirstName(borrower.getLastName());
		currentBorrower.setSsn(borrower.getSsn());
		currentBorrower.setBorrows(borrower.getBorrows());

		borrowerService.updateBorrower(currentBorrower);
		return new ResponseEntity<Borrower>(currentBorrower, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/borrower/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Borrower> deleteBorrower(@PathVariable("id") long id) {
		Borrower borrower = borrowerService.findById(id);
        if (borrower == null) {
            return new ResponseEntity<Borrower>(HttpStatus.NOT_FOUND);
        }
 
        borrowerService.deleteById(id);
        return new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
    }
	
	
	
	@RequestMapping(value = "/borrower/", method = RequestMethod.DELETE)
    public ResponseEntity<Borrower> deleteAllBorrowers() {
		borrowerService.deleteAllBorrowers();
        return new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
    }

}
