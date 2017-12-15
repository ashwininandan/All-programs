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
import com.file.upload.entity.User;
import com.file.upload.entity.repository.FileUploadRepository;
import com.file.upload.entity.repository.UserRepository;


@RestController
public class ProfilePicController {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	Environment environment;
	
	@Autowired
	FileUploadRepository filerepo;

	@Value("profile.uploads.destination")
	private String profileUploadDestination;
		
    @RequestMapping(value="/dp", method= RequestMethod.POST)
    public String handleFileUpload(
            @RequestParam("file") MultipartFile file,@RequestParam(name="userId")Long userId){
    
    	String name =environment.getProperty(profileUploadDestination);
    
     
        if (!file.isEmpty()) {
            try {
            	
            	FileUpload fileupload=new FileUpload();
            	User user = userrepo.findOne(userId);
                byte[] bytes = file.getBytes();
                Path path = Paths.get(name + file.getOriginalFilename());
                Files.write(path, bytes);
                String filename=UUID.randomUUID().toString();
           
               
             
                	environment.getProperty(name);
            	  
            	    user.setFirstName(user.getFirstName());
            	    user.setLastName(user.getLastName());
            	    user.setUserName(user.getUserName());
            	 	
            	 	
            	 	 fileupload.setFileName(file.getOriginalFilename());
                     fileupload.setRandomfileName(filename);
                     fileupload.setFilePath(name+file.getOriginalFilename());
                     fileupload.setFileSize(file.getSize());
                     fileupload.setContentType(file.getContentType());
                     fileupload.setContent(name);
                     
            	     fileupload = filerepo.save(fileupload);
            	     
            	     user.setProfilePicture(fileupload);
             	 	userrepo.save(user);
                
                	
            	
					
                
              	return "You successfully uploaded your profile picture " + name+file.getOriginalFilename();

           
            } 
                  
            
            
            catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage(); 
            }
           
            
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
       
        
    }
    
}


	


