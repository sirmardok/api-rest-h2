package com.mag.apirest.api_rest_h2.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Creación usuarios",
                version = "1.0.0",
                description = "Aplicación API Restful para la creación de usuarios con H2"
        )

)
public class OpenApiConfig {
}
