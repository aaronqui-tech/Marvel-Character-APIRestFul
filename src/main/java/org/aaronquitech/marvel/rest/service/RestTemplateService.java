package org.aaronquitech.marvel.rest.service;

import org.aaronquitech.project.dependecy.model.MarvelResponse;

/**
 * Servicio de cliente RestTemplate
 *
 * @author Aaron Quinonez
 * @since 01/02/2025
 */
public interface RestTemplateService {
    /** Metodo para obtener personajes
     *
     * @param url de API Marvel de Personajes
     * @return {@link MarvelResponse} objeto con personajes
     */
    MarvelResponse getRestService(String url);

    /** Metodo para obtener personaje por id
     *
     * @param url de API Marvel de Personaje por id
     * @return {@link MarvelResponse} objeto con personaje
     */
    MarvelResponse getCharactersId(String url);
}
