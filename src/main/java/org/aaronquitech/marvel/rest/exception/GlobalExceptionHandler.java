package org.aaronquitech.marvel.rest.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aaronquitech.marvel.rest.enums.ErrorMessageEnum;
import org.aaronquitech.marvel.rest.model.ApiError;
import org.aaronquitech.marvel.rest.util.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.aaronquitech.marvel.rest.exception.customized.NotDataFoundException;

/**
 * Handler exception
 *
 * @author Aaron Quinonez
 * @since 03/02/2025
 */
@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** Inyeccion de utilerias. */
    private final Utilities util;

    /**
     * Método que maneja una excepción {@link Exception}.
     *
     * @param request Objeto Http Servlet de petición.
     * @param ex Excepción recibida {@link Exception}
     * @return errorResponse {@link ApiError} respuesta específica para {@link Exception}.
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError generalException(Exception ex, WebRequest request) {
        String path = this.util.sanitizeString(((ServletWebRequest)request).getRequest().getRequestURI());
        ApiError apiError =
                ApiError.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(0,3))
                        .exception(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(4).toLowerCase())
                        .code(ErrorMessageEnum.UNKNOWN_ERROR.getCode())
                        .message(ErrorMessageEnum.UNKNOWN_ERROR.getMessage())
                        .path(path)
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }

    /**
     * Método para manejar una excepción de tipo {@link NotDataFoundException}.
     *
     * @param request Objeto Http Servlet de petición.
     * @param ex Excepción recibida {@link NotDataFoundException}
     * @return errorResponse {@link ApiError} respuesta específica para {@link
     *     NotDataFoundException}.
     */
    @ExceptionHandler(NotDataFoundException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiError handleNotDataFoundException(NotDataFoundException ex, WebRequest request) {
        String path = this.util.sanitizeString(((ServletWebRequest)request).getRequest().getRequestURI());
        ApiError apiError =
                ApiError.builder()
                        .status(HttpStatus.OK.toString().substring(0,3))
                        .exception("data_not_found")
                        .code(ex.getCode())
                        .message(ex.getMessage())
                        .path(path)
                        .build();
        log.debug(apiError.toString());
        return apiError;
    }
}
