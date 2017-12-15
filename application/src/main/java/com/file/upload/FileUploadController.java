package com.file.upload;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.upload.entity.FileUpload;

import com.file.upload.entity.repository.FileUploadRepository;


@RestController
public class FileUploadController {


	@Autowired
	FileUploadRepository filerepo;
	
	@Autowired
	Environment environment;

	@Value("file.uploads.destination")
	private String fileUploadDestination;
	
	//final String FILE_PATH =environment.getProperty(fileUploadDestination);
	
	
    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String handleFileUpload(
            @RequestParam("file") MultipartFile file){
    	
    	
    	
		/*how to do this global???*/
    	String name =environment.getProperty(fileUploadDestination);
    	
    	
        if (!file.isEmpty()) {
            try {
            	FileUpload fileupload=new FileUpload();
            	
            	
            	byte[] bytes = file.getBytes();
                
            	//Path path = Paths.get(name+file.getOriginalFilename());
                //Files.write(path,bytes);
                
                
                String filename=UUID.randomUUID().toString();
                environment.getProperty(name);
                fileupload.setFileName(file.getOriginalFilename());
                fileupload.setRandomfileName(filename);
                fileupload.setFilePath(name+file.getOriginalFilename());
                fileupload.setFileSize(file.getSize());
                fileupload.setContentType(file.getContentType());
                fileupload.setContent(name);
                
                Path path = Paths.get(name+filename);
                Files.write(path,bytes);
                
                
                
                
                filerepo.save(fileupload);
              
              
                return "You successfully uploaded into " + name+file.getOriginalFilename();
              
            } 
                   
            catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage(); 
            }
            
         
            
            
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
                  
        
    }
    
}