package com.principal.alomaster.config;

import com.principal.alomaster.servlet.UploadServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<UploadServlet> uploadServlet() {
        ServletRegistrationBean<UploadServlet> registrationBean = new ServletRegistrationBean<>(new UploadServlet(), "/upload");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}