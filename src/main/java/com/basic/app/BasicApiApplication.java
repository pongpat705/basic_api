package com.basic.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@Configuration
@EnableSwagger2
@SpringBootApplication
public class BasicApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApiApplication.class, args);
	}

	
	@Bean
	public Docket theApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.basic.app.contoller.api"))
				.paths(PathSelectors.ant("/api/*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Basic Api App")
            .description("learning how to create api")
            .version("0.1")
            .build();
    }
}

