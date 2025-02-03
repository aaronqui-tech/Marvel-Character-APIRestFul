package org.aaronquitech.marvel.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuracion de RestTemplate
 *
 * @author Aaron Quinonez
 * @since 01/02/2025
 */
@Configuration
public class RestTemplateConfig {
    /**
     * Bean Rest Template
     * @return {@link RestTemplate} Bean
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
