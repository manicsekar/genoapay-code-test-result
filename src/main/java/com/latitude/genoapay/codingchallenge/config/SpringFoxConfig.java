package com.latitude.genoapay.codingchallenge.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.latitude.genoapay.codingchallenge.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(apiKey(),bearer()))
                .apiInfo(apiInfo());

    }

    private static ApiKey apiKey() {
        return new ApiKey("ApiKey","API-Key","header");
    }

    private static ApiKey bearer() {
        return new ApiKey("Bearer","Authorization","header");
    }

    private static ApiInfo apiInfo(){
        return new ApiInfo("Stock Profit API","Stock Profit Service API","","",null,"","", Collections.emptyList());

    }



}
