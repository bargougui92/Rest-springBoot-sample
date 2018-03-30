package com.Restful.webservices.example01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

//Configuration 
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "oussama", "http://facebook.com", "oussama@cakemail.com"
    );


    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Api Documentation title",
            "Api Documentation description here",
            "1.0",
            "link",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "apacheURL"
    );

    //swagger-ui.html see swagger docs of the app
    //Bean -Docket---- /v2/api-docs
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                ;
    }

    //Swagger2
    //Allpaths
    //All apis
}
