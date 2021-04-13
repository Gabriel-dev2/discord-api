package com.discord.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    // @Autowired
    // private BuildProperties buildProperties;

    ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
            .title("Discord Api")
            .description("Api para integração com discord")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version(version)
            .contact(new Contact("","", "gabriel23costalima@outlook.com"))
            .build();
    }
    
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        .groupName("discord-api")
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/api/.*"))
        .build()
        .apiInfo(apiInfo("1.0.0"))
        .securityContexts(Arrays.asList(securityContext()))
        .securitySchemes(Arrays.asList(securitySchemes()));
    }

    @Bean
    public WebMvcConfigurer fowardToIndex() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/swagger").setViewName("redirect:/swagger-ui.html");
            }
        };
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder().useBasicAuthenticationWithAccessCodeGrant(true).build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
        .securityReferences(Arrays.asList(new SecurityReference("ra-auth", new AuthorizationScope[0])))
        .forPaths(PathSelectors.regex("/api/v\\d+.*")).build();
    }

    private SecurityScheme securitySchemes() {
        ResourceOwnerPasswordCredentialsGrant grant2 = new ResourceOwnerPasswordCredentialsGrant("".concat("/oauth/token"));
        SecurityScheme oauth = new OAuthBuilder().name("ra-auth").grantTypes(Arrays.asList(grant2)).build();
        return oauth;
    }
}
