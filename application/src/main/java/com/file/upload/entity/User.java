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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String password;
	private String firstName;
	private String LastName;
	private long phonenumber;
	private Date created;
	private Date updated;
	
	@OneToOne
	@JoinColumn(name="profile_picture")
	private FileUpload profilePicture;
	
	
	
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_chat", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "chat_id") })
	public Set<Chat> chats;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	
	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	

	public FileUpload getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(FileUpload profilePicture) {
		this.profilePicture = profilePicture;
	}


	public Set<Chat> getChats() {
		return chats;
	}

	public void setChats(Set<Chat> chats) {
		this.chats = chats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
