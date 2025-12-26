package com.example.demo.config;

import jakarta.servlet.http.*;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> helloServlet() {
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
                try {
                    resp.getWriter().write("Hello from simple servlet");
                } catch (Exception ignored) {}
            }
        };
        return new ServletRegistrationBean<>(servlet, "/hello-servlet");
    }
}
