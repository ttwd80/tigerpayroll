package com.github.ttwd80.tigerpayroll.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.ttwd80.tigerpayroll.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
