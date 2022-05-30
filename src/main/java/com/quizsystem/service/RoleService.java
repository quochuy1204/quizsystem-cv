package com.quizsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizsystem.model.Role;
import com.quizsystem.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findRoleById(int id) {
		Role role = new Role();
		role = roleRepository.findById(id).get();
		return role;
	}
}
