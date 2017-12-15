package com.file.upload.entity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.file.upload.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	Page<Message> findByChatId(@Param("chatId") long chat, Pageable pageable);
	// Set<Message> findByChatId(long chatId);

}
