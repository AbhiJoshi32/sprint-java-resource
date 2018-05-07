package com.binktec.sprint_resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.binktec.sprint_resource.web.repository")
public class SprintResourceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SprintResourceApplication.class, args);
	}
}
