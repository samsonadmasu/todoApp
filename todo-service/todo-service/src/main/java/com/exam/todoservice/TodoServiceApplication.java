package com.exam.todoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.exam.todoservice.controllers"})
public class TodoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}
}
