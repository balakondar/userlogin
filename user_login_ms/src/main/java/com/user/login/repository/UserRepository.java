package com.user.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.login.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	 @Transactional
	 @Query("select u from User u  where u.email = :email and u.password = :password")
	 public User loginUser(@Param("email") String email, @Param("password") String password);
	 
}
