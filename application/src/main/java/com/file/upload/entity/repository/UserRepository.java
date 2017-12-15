package com.file.upload.entity.repository;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.file.upload.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	Set<User> findByUserNameIgnoreCase(@Param("name") String name);

	Set<User> findById(long userId);

}
