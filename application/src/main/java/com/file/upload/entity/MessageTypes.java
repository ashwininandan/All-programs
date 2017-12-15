/**
 * 
 */
package com.file.upload.entity;

/**
 * @author win 10
 *
 */
public enum MessageTypes {

	file("0"), text("1");

	String type;

	private MessageTypes(String type) {
		this.type = type;
	}

	public String getMessageTypes() {
		return this.type;
	}
}
