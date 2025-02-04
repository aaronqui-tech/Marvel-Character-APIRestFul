package org.aaronquitech.marvel.rest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class UtilitiesTest {
    @InjectMocks
    private Utilities utilities;

    @Test
    void sanitizeStringTest(){
        Assertions.assertNotNull(this.utilities.sanitizeString("1"));
    }

    @Test
    void getCurrentPageTest(){
        Pageable pageable = PageRequest.of(0,10);
        int page = pageable.getPageNumber();
        Assertions.assertEquals(0,page);
    }

}
