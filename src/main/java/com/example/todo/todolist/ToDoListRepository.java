package com.example.todo.todolist;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long>{

	Optional<ToDoList> findListByUserName(String userName);

	@Query("SELECT u FROM ToDoList u WHERE u.user.id=?1")
	Optional<ToDoList> findUserByID(long id);
}
