package com.unimini.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @package : com.unimini.config
 * @name : WebConfig.java
 * @date : 2021-10-26 오전 9:43
 * @author : jeongwon.song
 * @version : 1.0.0
 * @modifyed :
 **/
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.unimini.controller", "com.unimini.exception"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");

    }

}
