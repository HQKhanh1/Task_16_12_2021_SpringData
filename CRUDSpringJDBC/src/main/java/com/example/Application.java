package com.example;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Employee;
import com.example.repository.EmployeeJDBCRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeJDBCRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10011L, "Ngoc", "Nguyen", "ngoc@gmail.com")));
		logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10012L, "Long", "Phan Dinh", "longpdh@gmail.com")));
		logger.info("Inserting -> {}", employeeRepository.insert(new Employee(10013L, "Thu", "Le", "thu@gmail.com")));

		logger.info("Employee id 10011 -> {}", employeeRepository.findById(10011L));

		logger.info("Update 10011 -> {}", employeeRepository.update(new Employee(10011L, "Ngoc", "Nguyen Bao", "baongoc@gmail.com")));

		employeeRepository.deleteById(10013L);

		logger.info("All users -> {}", employeeRepository.findAll());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
