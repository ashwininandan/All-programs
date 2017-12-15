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
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class FileUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String fileName;
	private String randomfileName; 
	private long fileSize;
	private Date uploadedDate;
	private String filePath;
	
	private String contentType;
	private String content;
	
	

	public String getRandomfileName() {
		return randomfileName;
	}

	
	public void setRandomfileName(String randomfileName) {
		this.randomfileName = randomfileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	@PrePersist
	protected void OnCreate() {
		uploadedDate = new Date();
	}

}
