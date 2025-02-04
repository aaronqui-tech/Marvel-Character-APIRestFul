package org.aaronquitech.marvel.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aaronquitech.marvel.rest.constant.PatternConstant;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Modelo de datos para Bitacora
 *
 * @author Aaron Quinonez
 * @since 03/02/2025
 */
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LogResponse implements Serializable {

    /** Serial version. */
    private static final long serialVersionUID = 2063716570994293415L;

    /** Id principal */
    private Long id;
    /** Propiedad de Proceso. */
    private String apiEndpoint;
    /** Propiedad Canal. */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PatternConstant.DATE_FULL_PATTERN)
    private LocalDateTime datetime;

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
