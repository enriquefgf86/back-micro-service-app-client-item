package com.microserviceitem.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {


    @Bean("clientRestTemplate")
    @LoadBalanced//en el caso de que se use restTemplate esta anotacion seria la encargada de remarcar el proceso
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
}
