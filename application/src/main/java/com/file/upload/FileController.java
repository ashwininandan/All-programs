package com.file.upload;
import java.io.File;

import java.io.IOException;
/**
 * 
 */
import java.util.ArrayList;

import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.file.upload.entity.FileUpload;
import com.file.upload.entity.repository.FileUploadRepository;

import com.file.upload.model.FileInformation;

@RestController
@RequestMapping

public class FileController {

	
	@Autowired
	FileUploadRepository fileUploadRepository;
	 String filePath;
	@ResponseBody
	@RequestMapping(value="/getFiles/{fileId}", method = RequestMethod.GET)
	
	public  Object getFiles(@PathVariable("fileId") long fileId) throws IOException
	{ 
	
		
		FileUpload files= fileUploadRepository.findOne(fileId);
		FileInformation fileInformation=null;
		FileUpload file=files;
		fileInformation = new FileInformation();
		fileInformation.setFilePath(file.getFilePath());
				if(file.getId()==fileId)
				{
					 filePath =fileInformation.getFilePath();
				
				}
				 File file1 = new File(filePath);
				 byte[] document = FileCopyUtils.copyToByteArray(file1);
				 HttpHeaders header = new HttpHeaders();
			       header.setContentType(new MediaType("application", "content-type"));
			       header.set("Content-Disposition", "inline; filename=" + file1.getName());
			       header.setContentLength(document.length);
			       return new HttpEntity<byte[]>(document, header);
			       
			   
	
	}
	
	    
}