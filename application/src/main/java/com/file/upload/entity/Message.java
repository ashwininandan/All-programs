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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String msg;
	private Date sendDate;
	
	@OneToOne
	@JoinColumn(name="file_path")
	private FileUpload filePath;
	

	private MessageTypes type;
	
	
	public MessageTypes getType() {
		return type;
	}
	
	

	public void setType(MessageTypes type) {
		this.type = type;
	}

	

	public FileUpload getFilePath() {
		return filePath;
	}



	public void setFilePath(FileUpload filePath) {
		this.filePath = filePath;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sender_id")
	private User sender;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chat_id")
	private Chat chat;

	
	

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@PrePersist
	protected void onCreate() {
		sendDate = new Date();
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

}
