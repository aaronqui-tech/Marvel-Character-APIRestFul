package org.aaronquitech.marvel.rest.service;


import org.aaronquitech.project.dependecy.model.MarvelResponse;

/**
 * Service Marvel Character
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
public interface MarvelService {

    /**
     * Servicio para obtener los personajes de Marvel
     *
     * @return
     */
    MarvelResponse charactersRetrieve();

    /**
     * Servicio para obtener un personaje de Marvel
     *
     * @param id Identificador del personaje
     * @return
     */
    MarvelResponse charactersRetrieve(String id);

}
