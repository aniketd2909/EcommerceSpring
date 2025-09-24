package org.example.ecommercespring;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // used to enable JPA auditing feature, used with createdAt, updatedAt
public class EcommerceSpringApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();
		dotenv.entries().forEach( dotenvEntry -> System.setProperty(dotenvEntry.getKey(), dotenvEntry.getValue()));
		SpringApplication.run(EcommerceSpringApplication.class, args);

	}

}
