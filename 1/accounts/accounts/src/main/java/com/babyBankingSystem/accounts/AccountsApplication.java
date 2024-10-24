package com.babyBankingSystem.accounts;

import com.babyBankingSystem.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImplementation")
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservice REST API Documentation",
				description = "BabyBanking Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Raji kehinde",
						email = "kehinderaji28@gmail.com",
						url = "https://www.babybanking.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.babybanking.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "BabyBanking Accounts microservice REST API Documentation",
				url = "https://www.babybanking.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
