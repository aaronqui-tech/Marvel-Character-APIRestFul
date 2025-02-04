package org.aaronquitech.marvel.rest.service;

import org.aaronquitech.marvel.rest.model.CharacterLogResponse;
import org.aaronquitech.marvel.rest.model.GlobalResponse;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.springframework.data.domain.Pageable;

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

    /**
     * Obtiene los datos registrados en Bitacora
     *
     * @return {@link CharacterLogResponse}
     */
    GlobalResponse<CharacterLogResponse> characterLogRetrieve(Pageable pageable);
}
