package me.tabernerojerry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity()
public class EasyBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBancoApplication.class, args);
	}

}
