package com.stackroute.muzix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Swagger config class
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${title}")
	String title;
	@Value("${description}")
	String description;
	@Value("${version}")
	String version;
	
	@Bean
	public Docket api() {
		
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("com.stackroute.muzix.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());
	}
	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title(title)
				.description(description)
				.version(version)
				.build();
	}
}