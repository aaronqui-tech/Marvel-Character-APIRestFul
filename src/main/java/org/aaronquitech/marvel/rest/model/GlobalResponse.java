package org.aaronquitech.marvel.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.aaronquitech.marvel.rest.constant.PatternConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
@Slf4j
@Builder
@AllArgsConstructor
@Getter
@Setter
public class GlobalResponse<T> implements Serializable {

    /** Serial Version. */
    private static final long serialVersionUID = -2448150535100098479L;

    /** Propiead codigo de respuesta. */
    private String code;

    /** Propiedad estatus de http */
    private String status;

    /** Propiedad hora de la respuesta. */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PatternConstant.DATE_FULL_PATTERN)
    private transient LocalDateTime timestamp;

    /** Objeto para la data de respuesta. */
    private transient T data;

    /**
     * Constructor de la repuesta global
     *
     * @param status  the successful response
     * @param data    the data
     */
    public GlobalResponse(String status, String code, T data) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

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
