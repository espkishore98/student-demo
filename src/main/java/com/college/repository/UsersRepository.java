package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}