package com.example.todo.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "api/v1/todolist")
public class ToDoListController {
	private final ToDoListService service;

	@Autowired
	public ToDoListController(ToDoListService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<ToDoList> getTaskList()
	{
		return service.getToDoList();
	}
	
	@GetMapping(path = "{toDoListId}")
	public ToDoList getListById(@PathVariable("toDoListId") long toDoListId)
	{
		return service.getToDoListById(toDoListId);
	}
	
	@PostMapping
	public String addNewTask(@RequestBody ToDoList list)
	{
		return service.addNewToDoList(list);
	}
	
	@DeleteMapping(path = "{toDoListId}")
	public String deleteTask(@PathVariable("toDoListId") long toDoListid)
	{
		return service.deleteToDoList(toDoListid);
	}
	
	@PutMapping(path = "{toDoListId}")
	public void updateToDoList(@PathVariable("toDoListId") long toDoListId, @RequestBody ToDoList toDoList)
	{
		service.updateToDoList(toDoListId , toDoList);
	}
}
