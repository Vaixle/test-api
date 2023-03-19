package com.vaixle.testapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info()
                        .title("QA Курс")
                        .version("v1.0.0")
                        .description("API для тестирования")
                        .contact(new Contact()
                                .name("Никита Олейников")
                                .url("https://instagram.com/nik.oleynikov")
                ));
    }
}
