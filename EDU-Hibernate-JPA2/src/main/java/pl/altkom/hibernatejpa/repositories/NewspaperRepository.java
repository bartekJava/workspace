package pl.altkom.hibernatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.hibernatejpa.model.Newspaper;

@Repository
public interface NewspaperRepository extends JpaRepository<Newspaper, Long>{

}
