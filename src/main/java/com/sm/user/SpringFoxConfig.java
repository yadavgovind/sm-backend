
package com.sm.user;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/.*"), regex("/api/.*"));
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Store management API")
                .description("Store management API reference for developers")
                .termsOfServiceUrl("http://localhost:8080.com")
                .contact("govind.yadav@gmail.com").license("NA")
                .licenseUrl("ovind.yadav@gmail.com").version("1.0").build();
    }
}