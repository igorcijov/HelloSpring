package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Java Pro. Homework #35
 *
 * @author Igor Cijov
 * @version 30 Nov 2022
 * Spring Boot + Thymeleaf + JPA + Liquibase + Logger + H2 Database Testing + RestController/Swagger
 *
 */


@SpringBootApplication
public class SimpleWebApp {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApp.class, args);
	}

}
