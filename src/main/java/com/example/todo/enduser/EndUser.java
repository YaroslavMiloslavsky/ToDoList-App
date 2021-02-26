package com.example.todo.enduser;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "end_user")
public class EndUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private LocalDate birthDay;
	
//	@OneToOne
//	private ToDoList listApp;
	
	@Transient
	private int age;
	
	public EndUser() {}

	public EndUser(String name, LocalDate birthDay) {
		this.name = name;
		this.birthDay = birthDay;
	}

	public EndUser(long id, String name, LocalDate birthDay) {
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public int getAge() {
		return Period.between(this.birthDay, LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
