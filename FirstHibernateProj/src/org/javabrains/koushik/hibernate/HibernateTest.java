package org.javabrains.koushik.hibernate;

import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.javabrains.koushik.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) 
	{
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		String minUserId = "5";
//		String userNameInj = "User 10";
//		
//		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName");
//		query.setParameter("userId", Integer.parseInt(minUserId));
//		query.setParameter("userName", userNameInj);
		
//		Query query = session.getNamedQuery("UserDetails.byId");
//		query.setParameter(0, 1);
		
//		query.setFirstResult(5);
//		query.setMaxResults(4);
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);
		Root<UserDetails> root = criteria.from(UserDetails.class);
		criteria.select(root);
//		criteria.where(builder.equal(root.get("userName"), "User 9"));
		criteria.where(builder.between(root.get("userId"), 2, 8));
		
		
		
		
		List<UserDetails> userNames = session.createQuery(criteria).getResultList(); 

//		for(int i=0; i<10; i++)
//		{
//			UserDetails user = new UserDetails();
//			user.setUserName("User " + (i+1));
//			session.save(user);
//		}
		
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("Size of Result List: " + users.size());
		for(UserDetails u : userNames)
		{
			System.out.println(u.getUserName());
		}
	}
}
