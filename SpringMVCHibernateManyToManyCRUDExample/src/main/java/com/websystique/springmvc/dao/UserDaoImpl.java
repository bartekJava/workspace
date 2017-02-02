package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao
{

	public User findById(int id) 
	{
		User user = getByKey(id);
		
		if(user!=null)
		{
            Hibernate.initialize(user.getUserProfiles());
        }
		
		return user;
	}
	

	public User findBySSO(String sso) 
	{
		System.out.println("SSO : "+sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User) crit.uniqueResult();
		
		if(user!=null)
		{
            Hibernate.initialize(user.getUserProfiles());
        }
		
		return user;
	}

	
	public void save(User user) 
	{
		persist(user);
		
	}

	
	public void deleteBySSO(String sso) 
	{
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User) crit.uniqueResult();
		delete(user);
	}

	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() 
	{
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<User> users = (List<User>) criteria.list();
		
		  /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
		
		return users;
	}

}
