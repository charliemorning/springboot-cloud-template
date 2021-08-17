package org.charlie.template.framework.configs.web;

import org.charlie.template.framework.interceptors.GlobalTraceIdInterceptorHandler;
import org.charlie.template.framework.interceptors.TemplateInterceptorHandler;
import org.charlie.template.framework.interceptors.TemplateInterceptorHandlerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TemplateWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(
                new GlobalTraceIdInterceptorHandler()
        ).addPathPatterns("/**");

        registry.addInterceptor(
                new TemplateInterceptorHandler()
        ).addPathPatterns("/**");

        registry.addInterceptor(
                new TemplateInterceptorHandlerAdapter()
        ).addPathPatterns("/**");
    }

}