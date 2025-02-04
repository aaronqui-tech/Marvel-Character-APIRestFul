package org.aaronquitech.marvel.rest.business;

import org.aaronquitech.marvel.rest.entity.CharacterLogEntity;
import org.aaronquitech.marvel.rest.enums.ErrorMessageEnum;
import org.aaronquitech.marvel.rest.exception.customized.NotDataFoundException;
import org.aaronquitech.marvel.rest.model.CharacterLogResponse;
import org.aaronquitech.marvel.rest.model.GlobalResponse;
import org.aaronquitech.marvel.rest.model.LogResponse;
import org.aaronquitech.marvel.rest.repository.CharacterLogRepository;
import org.aaronquitech.marvel.rest.service.MarvelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aaronquitech.marvel.rest.util.Utilities;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.aaronquitech.project.dependecy.service.MarvelCharacterService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    /** Inyección de Utilerias. */
    private final Utilities utilities;

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
        return mResponse;
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
    public GlobalResponse<CharacterLogResponse> characterLogRetrieve(Pageable pageable){
        log.info("Inicio proceso de busqueda de Bitacora.");
        /** Obtiene la pagina actual. */
        int currentPage = this.utilities.getCurrentPage(pageable);
        Page<CharacterLogEntity> logEntity = characterLogRepository
                .findAllByOrderByDatetimeDesc(PageRequest.of(currentPage, pageable.getPageSize()));

        if(logEntity.isEmpty()){
            throw new NotDataFoundException(ErrorMessageEnum.NOT_DATA_FOUND.getCode(),
                    ErrorMessageEnum.NOT_DATA_FOUND.getMessage());
        }
        Page<LogResponse> logResponse = logEntity.map(this::mapping);

        log.info("Finalizo busqueda de Bitacora.");
        return new GlobalResponse<>(HttpStatus.OK.toString().substring(0, 3), "OK",
                CharacterLogResponse.builder()
                        .logs(logResponse.getContent())
                        .totalPages(logResponse.getTotalPages())
                        .firstPage(logResponse.isFirst())
                        .lastPage(logResponse.isLast())
                        .currentPage(currentPage)
                        .build());
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
