package com.github.ttwd80.tigerpayroll.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.ttwd80.tigerpayroll.model.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	List<UserRole> findByUserByUsernameUsername(String username);
}
