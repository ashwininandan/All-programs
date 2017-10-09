package com.chat.app.entity.repo;

import java.util.Set;
import com.chat.app.entity.Chat;

public interface ChatRepositoryCustom  {

	Set<Chat> getUser1LikeAndUser2Like(String User1,String User2);
	
}
