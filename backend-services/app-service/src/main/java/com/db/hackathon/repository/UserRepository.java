package com.db.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.hackathon.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String email);
}