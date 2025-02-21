package dev.fedosov.springcourse.Project3Boot;

import dev.fedosov.springcourse.Project3Boot.services.SensorsService;
import dev.fedosov.springcourse.Project3Boot.validators.UniqueSensorNameValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Project3BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project3BootApplication.class, args);
	}

	@Bean
	public UniqueSensorNameValidator uniqueSensorNameValidator(SensorsService sensorsService) {
		return new UniqueSensorNameValidator(sensorsService);
	}
}
