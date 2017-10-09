package com.chat.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;


@Entity
public class Message {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String msg;



private Date sendDate;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="sender_id")
private User sender;


@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="chat_id")
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
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
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
