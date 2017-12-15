package com.file.upload.model;

import java.util.Date;

public class MessageInformation {

	private String msg;
	private Date sendDate;

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
