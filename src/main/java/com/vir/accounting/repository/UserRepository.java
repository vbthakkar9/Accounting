package com.vir.accounting.repository;

import com.vir.accounting.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Admin
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
