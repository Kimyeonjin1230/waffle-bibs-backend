package com.gdsc.waffle.config;

import com.gdsc.waffle.TestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                // select() : ApiSelectorBuilder 를 활성화 하여, Builder 형태로 합니다.
                .select()
                // apis()
                // API문서에 출력할 패키지 경로를 지정. (String)
                .apis(RequestHandlerSelectors.basePackage("app.server.api"))
                // paths()
                // API문서에 출력할 URL 경로 지정. (String)
                .paths(PathSelectors.ant("/api/**"))
                // build() : build
                .build()
                // apiInfo()
                // API문서 title, version 등 설정 진행.
                .apiInfo(apiInfo())
                // swagger에서 제공하는 기본 응답 코드 설명 제거
                .useDefaultResponseMessages(false)
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bibs Swagger")
                .description("Todo List API Document")
                .version("1.0")
                .build();
    }

}
