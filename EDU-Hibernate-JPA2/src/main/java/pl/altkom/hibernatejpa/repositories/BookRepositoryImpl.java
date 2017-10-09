package pl.altkom.hibernatejpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import pl.altkom.hibernatejpa.model.Author;
import pl.altkom.hibernatejpa.model.Book;

public class BookRepositoryImpl implements BookRepositoryCustom{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Book> findByTitleRegex(String regex) {
		Query query = entityManager.createQuery(
				"select b from Book b where lower(b.title) like :regex").setParameter("regex", "%"+regex+"%");
		List<Book> result = query.getResultList();
		return result;
	}

}
