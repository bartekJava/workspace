package pl.altkom.hibernatejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.hibernatejpa.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
