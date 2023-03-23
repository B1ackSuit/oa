package cn.ean.oaemp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;
import java.util.List;


/**
 * @FileName Swagger2Config
 * @Author ean
 * @Date 2023/3/14 15:26
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.ean.oaemp.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api接口文档")
                .description("接口文档")
                .contact(new Contact("ean", "http://localhost:8081/doc.html", "ean969648839@163.com"))
                .version("0.0.1-SNAPSHOT")
                .build();
    }

    private List<SecurityScheme> securitySchemes(){
        SecurityScheme scheme = new ApiKey(
                "Authorization","Authorization","header"
        );
        List<SecurityScheme> result = new ArrayList<>();
        result.add(scheme);
        //设置请求头信息
        // List<ApiKey> result = new ArrayList<>();
        // ApiKey apiKey = new ApiKey("Authorization","Authorization","header");
        // result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        // 设置需要登录认证的路径
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(getContextByPath("/hello/.*"));
        return securityContexts;
    }


    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }



}
