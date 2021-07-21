package com.example.profit;

import com.example.profit.api.WorkoutResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(WorkoutResource.class);
    }
}