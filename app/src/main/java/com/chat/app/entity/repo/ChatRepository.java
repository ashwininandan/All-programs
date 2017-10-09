package com.chat.app.entity.repo;




import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.chat.app.entity.Chat;


public interface ChatRepository extends PagingAndSortingRepository<Chat, Long> {

	Set<Chat> findByUserOneIdOrUserTwoId(long userOneId, long userTwoId);
}
