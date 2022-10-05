package com.lutomiah.lendingengine;

import com.lutomiah.lendingengine.entity.User;
import com.lutomiah.lendingengine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(LendingengineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(1L, "John", "Doe", 28, "Professional Thief"));
		userRepository.save(new User(2L, "Jane", "Doe", 25, "Software Developer"));
		userRepository.save(new User(3L, "Chuck", "Rhodes", 25, "District Attorney"));
		userRepository.save(new User(4L, "Bobby", "Axel", 25, "Entrepreneur"));
	}
}
