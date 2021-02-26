package com.example.todo.todolist;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.enduser.EndUserRepository;
import com.example.todo.exception.ApiNotFoundException;

@Service
public class ToDoListService {
	private final ToDoListRepository repository;
	private final EndUserRepository userRepo;
	private final String notFound = "list now found";

	public ToDoListService(ToDoListRepository repository , EndUserRepository uesrRepo) {
		this.repository = repository;
		this.userRepo = uesrRepo;
	}
	
	public List<ToDoList> getToDoList()
	{
		return repository.findAll();
	}
	
	public ToDoList getToDoListById(long toDoListId) {
		ToDoList toDoList = repository.findById(toDoListId)
				.orElseThrow(()-> new ApiNotFoundException(notFound));
		return toDoList;
	}


	public String addNewToDoList(ToDoList list) {
		//First we check if this user exists
		if(userRepo.existsById(list.getUser().getId()))
		{
			Optional<ToDoList> optionalList = repository.findListByUserName(list.getUser().getName());
			//Now we check if the user has already bee given a task
			if(!optionalList.isPresent())
			{
				repository.save(list);
				return String.format("User %s was given a task", list.getUser().getName());
			}
		}
		return "This user has a task already";		
	}


	public String deleteToDoList(long toDoListid) {
		if(!listIdExists(toDoListid))
			throw new ApiNotFoundException(notFound);
		else 
		{
			repository.deleteById(toDoListid);
			return toDoListid + " was deleted";
		}
	}

	@Transactional
	public void updateToDoList(long toDoListId,ToDoList toDoList) {
		if(!repository.existsById(toDoListId))
			throw new ApiNotFoundException(notFound);
		repository.save(toDoList);		
	}
	
	/* Utility functions */
	private boolean listIdExists(long id)
	{
		Optional<ToDoList> optionalToDoList = repository.findById(id);
		return optionalToDoList.isPresent();
	}
	
}
