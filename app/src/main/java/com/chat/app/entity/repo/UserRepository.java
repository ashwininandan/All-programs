package com.chat.app.entity.repo;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.chat.app.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	Set<User> findByUserNameIgnoreCase(@Param("name")String name);

}
