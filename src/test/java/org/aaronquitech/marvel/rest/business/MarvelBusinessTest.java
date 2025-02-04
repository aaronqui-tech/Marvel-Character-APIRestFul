package org.aaronquitech.marvel.rest.business;

import org.aaronquitech.marvel.rest.entity.CharacterLogEntity;
import org.aaronquitech.marvel.rest.exception.customized.NotDataFoundException;
import org.aaronquitech.marvel.rest.model.CharacterLogResponse;
import org.aaronquitech.marvel.rest.model.GlobalResponse;
import org.aaronquitech.marvel.rest.repository.CharacterLogRepository;
import org.aaronquitech.marvel.rest.util.Utilities;
import org.aaronquitech.project.dependecy.model.MarvelResponse;
import org.aaronquitech.project.dependecy.service.MarvelCharacterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MarvelBusinessTest {

    @InjectMocks
    private MarvelBusiness marvelBusiness;

    @Mock
    private MarvelCharacterService marvelCharacterService;
    @Mock
    private CharacterLogRepository characterLogRepository;
    @Mock
    private Utilities utilities;

    @Test
    void charactersRetrieveTest(){
        MarvelResponse response = new MarvelResponse(); // Reemplaza con la estructura real
        Mockito.when(marvelCharacterService.getCharacter()).thenReturn(response);
        MarvelResponse mResponse = marvelBusiness.charactersRetrieve();
        Assertions.assertNotNull(mResponse);
    }

    @Test
    void charactersRetrieveIdTest(){
        MarvelResponse response = new MarvelResponse();
        Mockito.when(marvelCharacterService.getCharacterByID("1009144")).thenReturn(response);
        MarvelResponse mResponse = marvelBusiness.charactersRetrieve("1009144");
        Assertions.assertNotNull(mResponse);
    }

    @Test
    void characterLogRetrieveTest(){
        Mockito.when(utilities.getCurrentPage(PageRequest.of(0,10)))
                .thenReturn(0);
        Page<CharacterLogEntity> logPage = new PageImpl<>(List.of(
                CharacterLogEntity.builder()
                        .id(1L).apiEndpoint("charactersRetrieve")
                        .datetime(LocalDateTime.now()).build()),
                PageRequest.of(0,10), 1);
        Mockito.when(characterLogRepository.findAllByOrderByDatetimeDesc(Mockito.any(PageRequest.class))).thenReturn(logPage);
        GlobalResponse<CharacterLogResponse> response = marvelBusiness.characterLogRetrieve(
                PageRequest.of(0,10));
        Assertions.assertNotNull(response);
    }

    @Test
    void testCharacterLogRetrieveExceptionTest() {
        Mockito.when(utilities.getCurrentPage(PageRequest.of(0,10)))
                .thenReturn(0);
        Pageable pageable = PageRequest.of(0,10);
        Page<CharacterLogEntity> emptyPage = Page.empty();
        Mockito.when(characterLogRepository.findAllByOrderByDatetimeDesc(Mockito.any(PageRequest.class)))
                .thenReturn(emptyPage);
        Assertions.assertThrows(NotDataFoundException.class,() -> {
            this.marvelBusiness.characterLogRetrieve(pageable);});
    }
}
