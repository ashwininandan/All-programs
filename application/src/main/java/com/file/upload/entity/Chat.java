package com.file.upload.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date startDate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_chat", joinColumns = { @JoinColumn(name = "chat_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	public Set<User> users;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_one_id")
	private User userOne;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_two_id")
	private User userTwo;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User getUserOne() {
		return userOne;
	}

	public void setUserOne(User userOne) {
		this.userOne = userOne;
	}

	public User getUserTwo() {
		return userTwo;
	}

	public void setUserTwo(User userTwo) {
		this.userTwo = userTwo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@PrePersist
	protected void onCreate() {
		startDate = new Date();
	}

}
