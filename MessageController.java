/**
 * 
 */
package com.chat.app;

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


import com.chat.app.entity.Message;
import com.chat.app.entity.repo.MessageRepository;
import com.chat.app.model.MessageInformation;

@RestController
@RequestMapping(path="/api")
public class MessageController {

	
	@Autowired
	MessageRepository messageRepository;

	@PostMapping("/getChatMessages")
	public List<MessageInformation> getChatMessages(@RequestParam(name="chatId")long chatId)
	{ 
	
		List<MessageInformation> messageInformations=null;
		Set<Message> messages = messageRepository.findByChatId(chatId);
		if (!CollectionUtils.isEmpty(messages)) {
			messageInformations = new ArrayList<>(messages.size());
			MessageInformation messageInformation=null;
			for (Message message : messages) {
				messageInformation = new MessageInformation();
				messageInformation.setMsg(message.getMsg());
				if(message.getChat().getId()==chatId)
					messageInformation.setMsg(message.getMsg());
					//messageInformations.listIterator();
				else
					messageInformations.isEmpty();
		}
		}
		else
		messageInformations = Collections.emptyList();
		return messageInformations;
	}
}
 