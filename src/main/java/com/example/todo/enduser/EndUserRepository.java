package com.example.todo.enduser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Long>{
	
	@Query("SELECT u FROM EndUser u WHERE u.name=?1")
	Optional<EndUser> findUserByName(String name);
}
