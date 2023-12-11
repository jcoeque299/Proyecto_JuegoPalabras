package com.servidores.JuegoPalabras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.servidores.JuegoPalabras.*")
@ComponentScan(basePackages = { "com.servidores.JuegoPalabras.*" })
@EntityScan("com.servidores.JuegoPalabras.*")
public class JuegoPalabrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuegoPalabrasApplication.class, args);
	}

}
