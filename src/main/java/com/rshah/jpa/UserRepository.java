package com.rshah.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rshah.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}