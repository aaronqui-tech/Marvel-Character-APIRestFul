package org.aaronquitech.marvel.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.aaronquitech.marvel.rest.constant.PatternConstant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Modelo para el retorno de los errores.
 *
 * @author Aaron Quiñonez
 * @since 01/02/2025
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class ApiError implements Serializable {
    /** Serial Version. */
    private static final long serialVersionUID = 2531017872159214283L;
	
	/** Fecha y hora de error. */
    @Builder.Default
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PatternConstant.DATE_FULL_PATTERN)
    private LocalDateTime timestamp = LocalDateTime.now();
    /** Estatus de error. */
    private String status;
    /** Descripcion del error. */
    private String exception;
    /** Descripcion del error. */
    private String code;
    /** Mensaje del error. */
    private String message;
    /** Recurso del error. */
    private String path;

    /**
     * Metodo toString
     *
     * @return String en Formato JSON
     */
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = StringUtils.EMPTY;
        try {
            jsonString = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return jsonString;
    }
}
