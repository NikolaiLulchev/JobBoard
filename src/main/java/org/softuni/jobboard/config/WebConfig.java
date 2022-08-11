package org.softuni.jobboard.config;

import org.softuni.jobboard.interceptors.AuthInterceptor;
import org.softuni.jobboard.interceptors.MaintenanceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;
    private final MaintenanceInterceptor maintenanceInterceptor;

    public WebConfig(AuthInterceptor authInterceptor, MaintenanceInterceptor maintenanceInterceptor) {
        this.authInterceptor = authInterceptor;
        this.maintenanceInterceptor = maintenanceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
        registry.addInterceptor(maintenanceInterceptor);
    }
}
