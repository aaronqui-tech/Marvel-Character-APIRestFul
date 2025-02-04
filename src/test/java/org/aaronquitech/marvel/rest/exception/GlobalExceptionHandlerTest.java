package org.aaronquitech.marvel.rest.exception;

import org.aaronquitech.marvel.rest.exception.customized.NotDataFoundException;
import org.aaronquitech.marvel.rest.model.ApiError;
import org.aaronquitech.marvel.rest.util.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {
    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private Utilities utilities;

    @Test
    void generalExceptionTest(){
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
                mockRequest.setRequestURI("/test-endpoint");
        WebRequest webRequest = new ServletWebRequest(mockRequest);
        Mockito.when(utilities.sanitizeString(Mockito.anyString())).thenReturn("/test-endpoint");
        ApiError response = globalExceptionHandler.generalException(
                new RuntimeException("Mensaje"), webRequest);
        Assertions.assertEquals("500", response.getStatus());
    }

    @Test
    void handleNotDataFoundExceptionTest(){
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        mockRequest.setRequestURI("/test-endpoint");
        WebRequest webRequest = new ServletWebRequest(mockRequest);
        Mockito.when(utilities.sanitizeString(Mockito.anyString())).thenReturn("/test-endpoint");
        ApiError response = globalExceptionHandler.handleNotDataFoundException(
                new NotDataFoundException("Mensaje"), webRequest);
        Assertions.assertEquals("404", response.getStatus());
    }

    @Test
    void httpMessageNotWritableExceptionTest(){
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        mockRequest.setRequestURI("/test-endpoint");
        WebRequest webRequest = new ServletWebRequest(mockRequest);
        Mockito.when(utilities.sanitizeString(Mockito.anyString())).thenReturn("/test-endpoint");
        ApiError response = globalExceptionHandler.httpMessageNotWritableException(
                new HttpMessageNotWritableException("Mensaje"), webRequest);
        Assertions.assertEquals("500", response.getStatus());
    }

}
