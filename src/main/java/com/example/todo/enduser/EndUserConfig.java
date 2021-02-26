package com.example.todo.enduser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * This class was written to give some starting values, feel free to rewrite or delete
 */
@Configuration
public class EndUserConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(EndUserRepository endUserRepository)
	{
		return args ->
		{
			// Add test if needed here
		};
	}
}
