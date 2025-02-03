package org.aaronquitech.marvel.rest.business;

import org.aaronquitech.marvel.rest.service.MarvelService;
import org.aaronquitech.marvel.rest.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.aaronquitech.project.dependecy.service.MarvelCharacterService;
import org.springframework.stereotype.Service;

/**
 * Capa de negocio de personajes Marvel
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MarvelBusiness implements MarvelService {

    /** Inyección clase Utils. */
    private final Utils utils;
    /** Inyección clase servicio RestTemplate. */
    private final MarvelCharacterService marvelCharacterService;

    /** {@inheritDoc} */
    @Override
    public MarvelResponse charactersRetrieve(){
        MarvelResponse mResponse = marvelCharacterService.getCharacter();
        log.info("charactersRetrieve consumido.");
        return marvelCharacterService.getCharacter();
    }

    /** {@inheritDoc} */
    @Override
    public MarvelResponse charactersRetrieve(String id){
        MarvelResponse mResponse = marvelCharacterService.getCharacterByID(id);
        log.info("charactersRetrieve por id consumido.");
        return mResponse;
    }
}
