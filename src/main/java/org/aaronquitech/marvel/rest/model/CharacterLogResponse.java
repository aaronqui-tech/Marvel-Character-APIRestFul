package org.aaronquitech.marvel.rest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Clase con lista de Objetos LogResponse
 *
 * @author Aaron QUinonez
 * @since 03/03/2025
 */
@Slf4j
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class CharacterLogResponse extends Paginator implements Serializable {

    /** Serial Version. */
    private static final long serialVersionUID = 7160361854530789978L;

    /** Lista de logs. */
    List<LogResponse> logs;

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