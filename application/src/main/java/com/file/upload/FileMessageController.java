/**
 * 
 */
package com.file.upload;

/**
 * @author win 10
 *
 */

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

import com.file.upload.entity.Chat;
import com.file.upload.entity.FileUpload;
import com.file.upload.entity.Message;
import com.file.upload.entity.MessageTypes;
import com.file.upload.entity.User;
import com.file.upload.entity.repository.ChatRepository;
import com.file.upload.entity.repository.FileUploadRepository;
import com.file.upload.entity.repository.MessageRepository;
import com.file.upload.entity.repository.UserRepository;

@RestController
public class FileMessageController {

	@Autowired
	UserRepository userrepo;

	@Autowired
	ChatRepository chatrepo;

	@Autowired
	MessageRepository msgrepo;
	
	@Autowired
	FileUploadRepository filerepo;

	@Autowired
	Environment environment;

	@Value("conversation.file.destination")
	private String conversationFileUploadDestination;

	@RequestMapping(value = "/conversation", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam(name = "userId") User userId,
			@RequestParam(name = "chatId") Chat chatId, @RequestParam(name = "type") MessageTypes type) {

		String name = environment.getProperty(conversationFileUploadDestination);

		if (!file.isEmpty()) {
			try {
				
				FileUpload fileupload=new FileUpload();
				// User user = userrepo.findOne(userId);
				// Chat chat=chatrepo.findOne(chatId);
				Message msg = new Message();
				byte[] bytes = file.getBytes();
				Path path = Paths.get(name + file.getOriginalFilename());
				Files.write(path, bytes);
				 String filename=UUID.randomUUID().toString();

				environment.getProperty(name);

				msg.setSender(userId);
				msg.setChat(chatId);
				
				msg.setType(type);
				
				
				
				
				
					fileupload.setFileName(file.getOriginalFilename());
	                fileupload.setRandomfileName(filename);
	                fileupload.setFilePath(name+file.getOriginalFilename());
	                fileupload.setFileSize(file.getSize());
	                fileupload.setContentType(file.getContentType());
	                fileupload.setContent(name);
	           
	                fileupload=  filerepo.save(fileupload);
	                
	                msg.setFilePath(fileupload);
	                msgrepo.save(msg);
					
	              
				return "You successfully sent ur file " + name + file.getOriginalFilename();

			}

			catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}

		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}

	}

}
