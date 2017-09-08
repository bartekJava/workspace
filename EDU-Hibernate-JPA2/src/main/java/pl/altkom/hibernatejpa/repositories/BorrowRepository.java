package pl.altkom.hibernatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.hibernatejpa.model.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
