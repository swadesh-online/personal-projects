package com.database.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = { "com.*" }) 
@EntityScan("com.*")
public class QueryDbMultiTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryDbMultiTableApplication.class, args);
	}

}
