package com.example.Horarios.configuration;

import com.example.Horarios.interceptor.ValidationInterception;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class InterceptionConfig implements WebMvcConfigurer {
    private final ValidationInterception validationInterception;

    public InterceptionConfig(ValidationInterception validationInterception) {
        this.validationInterception = validationInterception;
    }

    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(validationInterception);
    }
}
