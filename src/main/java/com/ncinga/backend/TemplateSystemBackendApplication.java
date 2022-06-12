package com.ncinga.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Template WorkFlow System API",
        version = "1.0.0",
        description = "Simple REST API to handle templates and cards in the workflows"
    )
)
public class TemplateSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateSystemBackendApplication.class, args);
    }

}
