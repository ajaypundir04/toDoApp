
package com.emirates.todo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ajay Singh Pundir Application Start Up
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan("com.emirates.todo.entity")
public class TodoListAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListAppApplication.class, args);

	}
}
