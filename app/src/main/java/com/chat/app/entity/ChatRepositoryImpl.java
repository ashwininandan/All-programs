package com.chat.app.entity;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.chat.app.entity.repo.ChatRepositoryCustom;

@Transactional(readOnly = true)
public class ChatRepositoryImpl implements ChatRepositoryCustom {
	
	 @PersistenceContext
	    EntityManager entityManager;
	 
	    @Override
	    public Set<Chat> getUser1LikeAndUser2Like(String User1, String User2) {
	        Query query = entityManager.createNativeQuery("select m.* from public.message m, public.chat c\n" +
	                "where c.id = m.chat_id " +
	                "and m.User1 LIKE ? " +
	                "and m.User2 LIKE ? ", Chat.class);
	        query.setParameter(1, User1 + "%");
	        query.setParameter(2, User2);
	 
	        return (Set<Chat>) query.getResultList();
	    }

}
