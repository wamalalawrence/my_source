package com.lulimi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class LulimiApplication 
{

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LulimiApplication.class, args);
    }
    
    //global CORS configuration
    public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurerAdapter() {
		};
    }

}
