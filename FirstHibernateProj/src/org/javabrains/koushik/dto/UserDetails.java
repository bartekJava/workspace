package org.javabrains.koushik.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = ?")
//@NamedNativeQuery(name="UserDetails.byName", query="select * from userdetails where userName = ?", resultClass=UserDetails.class)
public class UserDetails 
{
	@Id @GeneratedValue
	private int userId;
	private String userName;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
