package org.aaronquitech.marvel.rest.business;

import org.aaronquitech.marvel.rest.entity.CharacterLogEntity;
import org.aaronquitech.marvel.rest.enums.ErrorMessageEnum;
import org.aaronquitech.marvel.rest.exception.customized.NotDataFoundException;
import org.aaronquitech.marvel.rest.model.LogResponse;
import org.aaronquitech.marvel.rest.repository.CharacterLogRepository;
import org.aaronquitech.marvel.rest.service.MarvelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.aaronquitech.project.dependecy.service.MarvelCharacterService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    /** Inyección clase servicio RestTemplate. */
    private final MarvelCharacterService marvelCharacterService;
    /** Inyección de Repositorio. */
    private final CharacterLogRepository characterLogRepository;

    /** {@inheritDoc} */
    @Override
    public MarvelResponse charactersRetrieve(){
        log.info("Inicio proceso de busqueda.");
        characterLogRepository.save(CharacterLogEntity.builder()
                .apiEndpoint("charactersRetrieve")
                .datetime(LocalDateTime.now())
                .build());
        MarvelResponse mResponse = marvelCharacterService.getCharacter();
        log.info("Finalizo busqueda.");
        return marvelCharacterService.getCharacter();
    }

    /** {@inheritDoc} */
    @Override
    public MarvelResponse charactersRetrieve(String id){
        log.info("Inicio proceso de busqueda por id.");
        characterLogRepository.save(CharacterLogEntity.builder()
                .apiEndpoint("charactersRetrieveId")
                .datetime(LocalDateTime.now())
                .build());
        MarvelResponse mResponse = marvelCharacterService.getCharacterByID(id);
        log.info("Finalizo busqueda por id.");
        return mResponse;
    }

    /** {@inheritDoc} */
    public List<LogResponse> characterLogRetrieve(){
        log.info("Inicio proceso de busqueda de Bitacora.");
        List<CharacterLogEntity> logEntity = characterLogRepository.findAllByOrderByDatetimeDesc()
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotDataFoundException(ErrorMessageEnum.NOT_DATA_FOUND.getCode(),
                        ErrorMessageEnum.NOT_DATA_FOUND.getMessage()));

        List<LogResponse> logResponse = logEntity.stream()
                .map(this::mapping)
                .collect(Collectors.toList());
        log.info("Finalizo busqueda de Bitacora.");
        return logResponse;
    }

    /**
     * Convierte un entity de tipo {@link CharacterLogEntity} a {@link LogResponse}
     *
     * @param entity entidad de ingredientes
     * @return {@link LogResponse} respuesta de bitacora
     */
    private LogResponse mapping(CharacterLogEntity entity) {
        return new ModelMapper().map(entity, LogResponse.class);
    }
}
