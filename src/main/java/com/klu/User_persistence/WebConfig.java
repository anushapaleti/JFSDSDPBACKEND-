package com.klu.User_persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Enable CORS for all endpoints under /api/
        registry.addMapping("/api/**") // Match all endpoints under /api/
                .allowedOrigins("http://localhost:5173") // Allow requests from frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
                .allowedHeaders("*") // Accept all headers
                .allowCredentials(true); // Enable credentials if needed
        
        // Add any additional mappings or custom configurations as needed for other modules
    }
}
