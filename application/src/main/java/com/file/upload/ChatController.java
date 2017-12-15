package com.file.upload;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.file.upload.entity.Chat;
import com.file.upload.entity.repository.ChatRepository;
import com.file.upload.model.ChatInformation;

@RestController
@RequestMapping//(path="/api")
public class ChatController {
	
	@Autowired
	ChatRepository chatRepository;

	/**
	 * 
	 * @param userId
	 * @return
	 */
	@PostMapping("/getUserChats")
	public List<ChatInformation> getUserChats(@RequestParam(name="userId")long userId)
	{ 
		List<ChatInformation> chatInformations = null;
		Set<Chat> chats = chatRepository.findByUserOneIdOrUserTwoId(userId, userId);
		if (!CollectionUtils.isEmpty(chats)) {
			chatInformations = new ArrayList<>(chats.size());
			ChatInformation chatInformation = null;
			for (Chat chat : chats) {
				chatInformation = new ChatInformation();
				chatInformation.setChatId(chat.getId());
				if(chat.getUserOne().getId()==userId)
					chatInformation.setUsername(chat.getUserTwo().getFirstName()+ " "+chat.getUserTwo().getLastName());
					
				else
					chatInformation.setUsername(chat.getUserOne().getFirstName()+ " "+chat.getUserOne().getLastName());
				chatInformations.add(chatInformation);
		
				
			}	
			
		}	
		else
			chatInformations = Collections.emptyList();
		return chatInformations;
	}
}
 
