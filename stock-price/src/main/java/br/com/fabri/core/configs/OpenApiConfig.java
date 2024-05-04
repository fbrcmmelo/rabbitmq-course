package br.com.fabri.core.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	private final String projectName;
	private final String projectVersion;
	private final String projectDescrption;

	public OpenApiConfig(@Value("${spring.application.name}") String projectName,
			@Value("${project.version}") String projectVersion,
			@Value("${project.description}") String projectDescription) {
		this.projectName = projectName;
		this.projectVersion = projectVersion;
		this.projectDescrption = projectDescription;
	}

	@Bean
	OpenAPI apiDocs() {
		return new OpenAPI()
				.info(new Info().title("API " + projectName.toUpperCase())
						.description(projectDescrption.toUpperCase())
						.version(projectVersion));
	}

}
