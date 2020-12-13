package in.ems.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CORSConfig {

    private static long MAX_AGE = 7200; // In seconds

    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "DELETE", "PATCH")
                .maxAge(MAX_AGE);
    }
}
