package com.chat.app.entity.repo;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.chat.app.entity.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long>{
	
	
	Set<Message> findByChatId(long chat);
	
}
