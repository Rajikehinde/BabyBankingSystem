package com.babyBanking.cards;

import com.babyBanking.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "babyBanking Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Raji Kehinde",
						email = "kehinderaji29.com",
						url = "https://www.babybanking.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.babybanking.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EasyBanking Cards microservice REST API Documentation",
				url = "https://www.babybanking.com"
		)
)
@SpringBootApplication
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
