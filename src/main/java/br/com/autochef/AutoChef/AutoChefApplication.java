package br.com.autochef.AutoChef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AutoChefApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoChefApplication.class, args);
	}

}
