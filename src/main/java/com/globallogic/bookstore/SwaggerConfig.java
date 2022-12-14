package com.globallogic.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//Run the Project as Spring Project
//Go to: http://localhost:8123/swagger-ui/index.html#/

public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket api() {
	 return new Docket(DocumentationType.SWAGGER_2)
	 .select()
	 .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	 .paths(PathSelectors.any())
	 .build();
	}
	
	public static ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Book Store")
				.description("Buy, sell and manage books.")
				.version("1.0")
				.build();
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");    
   }
	
}