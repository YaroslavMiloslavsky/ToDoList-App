package com.example.todo.todolist;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.todo.enduser.EndUser;

@Entity
@Table(name = "to_do")
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "tasks")
	@Column(name = "list")
	private List<String> taskList;
	@OneToOne
	@JoinColumn(name = "to_do")
	private EndUser user; 
	
	public ToDoList() {}//Default 
	
	public ToDoList(List<String> list , EndUser user)
	{
		this.taskList = list;
		this.user = user;
	}
	
	public ToDoList(long id, List<String> list , EndUser user)
	{
		this.id = id;
		this.taskList = list;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<String> taskList) {
		this.taskList = taskList;
	}

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}
	
	
	
}
