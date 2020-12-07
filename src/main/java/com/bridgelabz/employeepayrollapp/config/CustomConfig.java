package com.bridgelabz.employeepayrollapp.config;

import com.bridgelabz.employeepayrollapp.interceptor.MyCustomInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CustomConfig implements WebMvcConfigurer {

    @Autowired
    MyCustomInterceptor myCustomInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        registry.addInterceptor(myCustomInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
