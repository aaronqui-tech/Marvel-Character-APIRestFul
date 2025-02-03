package org.aaronquitech.marvel.rest.configuration;

import org.aaronquitech.project.dependecy.clienthttp.RestTemplateClient;
import org.aaronquitech.project.dependecy.impl.MarvelCharacterImpl;
import org.aaronquitech.project.dependecy.service.MarvelCharacterService;
import org.aaronquitech.project.dependecy.util.Utils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuracion de Beans de Dependencia
 *
 * @author Aaron Quinonez
 * @since 01/02/2025
 */
@Configuration
public class MarvelConsumeConfig {
    /**
     * Bean personajes marvel.
     * @return {@link MarvelCharacterService} Bean
     */
    @Bean
    public MarvelCharacterService characterBean() {
        return new MarvelCharacterImpl();
    }
    /**
     * Bean Utilerias.
     * @return {@link Utils} Bean
     */
    @Bean
    public Utils utilsBean() {
        return new Utils();
    }
    /**
     * Bean RestTemplate Http
     * @return {@link RestTemplateClient} Bean
     */
    @Bean
    public RestTemplateClient restTemplateClient() {
        return new RestTemplateClient();
    }
}
