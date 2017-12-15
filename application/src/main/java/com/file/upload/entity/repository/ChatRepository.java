package com.file.upload.entity.repository;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.file.upload.entity.Chat;

public interface ChatRepository extends PagingAndSortingRepository<Chat, Long> {

	/**
	 * 
	 * @param userOneId
	 * @param userTwoId
	 * @return
	 */
	Set<Chat> findByUserOneIdOrUserTwoId(long userOneId, long userTwoId);
}
