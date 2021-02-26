package com.example.todo.todolist;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.todo.enduser.EndUser;
import com.example.todo.enduser.EndUserRepository;

@Configuration
public class ToDoListConfig {
	@Bean
	CommandLineRunner commandLineRunnerList(ToDoListRepository repository , EndUserRepository userRepo)
	{
		//This is test
		return args ->
		{
			EndUser alex = new EndUser("Alex", LocalDate.of(1987, 4, 12));
			EndUser misha = new EndUser("Michael", LocalDate.of(1994, 11, 23));
			EndUser vicky = new EndUser("Vicky", LocalDate.of(2002, 1, 16));
			EndUser andre = new EndUser("Andre", LocalDate.of(1979, 2, 24));
			//This one is test case so we can add lists with the API itself
			EndUser test = new EndUser("Mark", LocalDate.of(1973,1, 1));
			userRepo.saveAll(List.of(alex,misha,vicky,andre,test));
			
			List<String>list1 = List.of("A","B","C");
			List<String>list2 = List.of("Q","T","V");
			List<String>list3 = List.of("U","I","M");
			List<String>list4 = List.of("X","Y","Z");
			
			ToDoList td1 = new ToDoList(list1 , alex);
			ToDoList td2 = new ToDoList(list2 , vicky);
			ToDoList td3 = new ToDoList(list3 , misha);
			ToDoList td4 = new ToDoList(list4 , andre);
			
			repository.saveAll(List.of(td1,td2,td3,td4));
			
		};
	}
}
