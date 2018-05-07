package com.binktec.sprint_resource.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.binktec.sprint_resource.web" })
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerWebConfig extends WebMvcConfigurerAdapter {
    //
}