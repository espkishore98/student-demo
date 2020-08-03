package com.students.demo.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.demo.domain.UsersEntity;



public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

}
