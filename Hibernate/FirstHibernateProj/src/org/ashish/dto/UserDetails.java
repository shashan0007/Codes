package org.ashish.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	
	private int userID;
	
	private String userName;
	
	@Lob
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	private Address address;

	public int getUserID() {
		return userID ;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
