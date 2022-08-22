package com.globallogic.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bookstore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findUserByEmail(String email);

}
