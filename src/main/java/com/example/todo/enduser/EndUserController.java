package com.example.todo.enduser;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class EndUserController {
	private final EndUserService endUserService;
	
	/* Here are the CRUD services */

	@Autowired
	public EndUserController(EndUserService endUserService) {
		this.endUserService = endUserService;
	}
	
	@GetMapping
	public List<EndUser> getUserList()
	{
		return endUserService.getUsers();
	}
	
	@GetMapping(path = "{endUserId}")
	public EndUser getUserById(@PathVariable("endUserId") long endUserId)
	{
		return endUserService.getUserById(endUserId);
	}
	
	@PostMapping
	public String addNewUser(@RequestBody EndUser user)
	{
		return endUserService.addEndUser(user);
	}
	
	@DeleteMapping(path = "{endUserId}")
	public void deleteUser(@PathVariable("endUserId") long endUserId)
	{
		endUserService.removeEndUser(endUserId);
	}
	
	@PutMapping(path = "{endUserId}")
	public void updateUser(@PathVariable("endUserId") long id,
							@RequestParam(required = false) String name,
							@RequestParam(required = false) LocalDate birthday)
	{
		endUserService.updateEndUser(id,name,birthday);
	}
	
}
