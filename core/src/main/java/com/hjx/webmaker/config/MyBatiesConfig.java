package com.hjx.webmaker.config;

import com.hjx.webmaker.modules.base.intercept.DesensitizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatiesConfig {
    @Bean
    public DesensitizationInterceptor desensitizationInterceptor() {
        DesensitizationInterceptor desensitizationInterceptor = new DesensitizationInterceptor();
        desensitizationInterceptor.setDesensitization(true);
        return desensitizationInterceptor;
    }
}
