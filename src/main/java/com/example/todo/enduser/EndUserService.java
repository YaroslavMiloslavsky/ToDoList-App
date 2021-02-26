package com.example.todo.enduser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.exception.ApiBadRequestException;
import com.example.todo.exception.ApiNotFoundException;

@Service
public class EndUserService {

	private final EndUserRepository endUserRepository;
	private final String notFound = "user not found";
	
	public EndUserService(EndUserRepository endUserRepository) {
		this.endUserRepository = endUserRepository;
	}

	public List<EndUser> getUsers() {
		return endUserRepository.findAll();
	}
	
	public EndUser getUserById(long endUserId) {
		EndUser user = endUserRepository.findById(endUserId)
				.orElseThrow(()-> new ApiNotFoundException(notFound));			
		return user;
	}
	
	public String addEndUser(EndUser user)
	{		
		if(existsByName(user)) 
			throw new ApiBadRequestException("Name already taken");
		else 
			{
				endUserRepository.save(user);
				return user.getName() + " was added successfuly";
			}
	}

	public void removeEndUser(long endUserId)
	{		
		if(!existsById(endUserId)) 
			throw new ApiNotFoundException(notFound);
		else 
			endUserRepository.deleteById(endUserId);
	}

	@Transactional
	public void updateEndUser(long id, String name, LocalDate birthday) {
		
		//We check if this user even exists first
		if(!existsById(id))
			throw new ApiNotFoundException(notFound);
		EndUser user = endUserRepository.getOne(id);
		
		// Here we check if the given name is not the same as the current and also if the name wasn't taken before
		if(name!=null && name.length()>0 && !user.getName().equals(name))
		{		
			if(existsByName(name))
				throw new ApiBadRequestException("user by the name " + name+" already exists");
			else 
				user.setName(name);
		}
		
		// The birthday date should be legal and not the same as the current one
		if(birthday!=null && !user.getBirthDay().equals(birthday))
			user.setBirthDay(birthday);
		
	}

	/* Utility functions*/
	private boolean existsByName(EndUser user)
	{
		Optional<EndUser> optionalUser = endUserRepository.findUserByName(user.getName());
		return optionalUser.isPresent();
	}
	
	private boolean existsByName(String username)
	{
		Optional<EndUser> optionalUser = endUserRepository.findUserByName(username);
		return optionalUser.isPresent();
	}
	
	private boolean existsById(long id)
	{
		Optional<EndUser> optionalUser = endUserRepository.findById(id);
		return optionalUser.isPresent();
	}
}
