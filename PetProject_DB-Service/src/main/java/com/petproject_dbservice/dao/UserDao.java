package com.petproject_dbservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petproject_dbservice.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
