package org.aaronquitech.marvel.rest.Rest;

import org.aaronquitech.marvel.rest.service.RestTemplateService;
import lombok.AllArgsConstructor;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Cliente RestTemplate
 *
 * @author Aaron Quinonez
 * @since 01/02/2025
 */
@Service
@AllArgsConstructor
public class RestTemplateImpl implements RestTemplateService {

    /** Inyección de dependecia. */
    private final RestTemplate restTemplate;

    /** {@inheritDoc} */
    @Override
    public MarvelResponse getRestService(String url){
        return restTemplate.getForObject(url, MarvelResponse.class);
    }

    /** {@inheritDoc} */
    public MarvelResponse getCharactersId(String url) {
        try {
            return restTemplate.getForObject(url, MarvelResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
