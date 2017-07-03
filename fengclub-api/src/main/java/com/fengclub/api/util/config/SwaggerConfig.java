package com.fengclub.api.util.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xiaohui on 2016/1/14.
 */
@EnableWebMvc  
@EnableSwagger2  
@ComponentScan(basePackages = {"com.fengclub.api.controller"})  
@Configuration  
public class SwaggerConfig extends WebMvcConfigurerAdapter{

	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fengclub.api.controller")) 
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口列表 v1.1.0") // 任意，请稍微规范点
                .description("接口列表") // 任意，请稍微规范点
                .termsOfServiceUrl("http://localhost:8090/swagger-ui.html") // 将“url”换成自己的ip:port
                .version("1.1.0")
                .build();
    }
    //下边的都是配置映射的，这个，我没办法给你们解释，水平不到.....  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        registry.addResourceHandler("swagger-ui.html")  
                .addResourceLocations("classpath:/META-INF/resources/");  
        registry.addResourceHandler("webjars/**")  
                .addResourceLocations("classpath:/META-INF/resources/webjars/");  
    }
}
