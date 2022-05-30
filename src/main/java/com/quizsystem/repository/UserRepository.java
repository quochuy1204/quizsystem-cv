package com.quizsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.quizsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM USER WHERE user.email = :email", nativeQuery = true)
	User getUserByEmail(@Param("email") String email);
}
