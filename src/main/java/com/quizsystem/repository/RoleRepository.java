package com.quizsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quizsystem.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
