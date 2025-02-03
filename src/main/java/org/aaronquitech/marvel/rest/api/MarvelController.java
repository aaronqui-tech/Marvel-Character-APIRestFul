package org.aaronquitech.marvel.rest.api;

import org.aaronquitech.marvel.rest.constant.RoutesConstant;
import org.aaronquitech.marvel.rest.service.MarvelService;
import lombok.RequiredArgsConstructor;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de personajes Marvel
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = RoutesConstant.BASE_PATH)
@RequiredArgsConstructor
public class MarvelController {

    /** Servicio personajes Marvel. */
    private final MarvelService marvelService;

    /**
     * Metodo para recuperar los personajes de marvel
     *
     * @return
     */
    @GetMapping(path = RoutesConstant.DOMAIN_CHARACTER_PATH)
    public MarvelResponse characterRetrieve(){
        return marvelService.charactersRetrieve();
    }

    /**
     * Metodo para recuperar un personaje
     *
     * @param id
     * @return
     */
    @GetMapping(path = RoutesConstant.DOMAIN_CHARACTER_ID_PATH)
    public MarvelResponse characterRetrieve(@PathVariable String id){
        return marvelService.charactersRetrieve(id);
    }
}
