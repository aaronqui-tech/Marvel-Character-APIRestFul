package org.aaronquitech.marvel.rest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Objeto de paginación.
 *
 * @author Aaron Quinonez
 * @since 03/02/2025
 */
@Slf4j
@Getter
@SuperBuilder(toBuilder = true)
public class Paginator implements Serializable{

    /** Serial Version. */
    private static final long serialVersionUID = 1348264563990802363L;

    /** Total de paginas. */
    private int totalPages;
    /** Total de elementos. */
    private long totalElements;
    /** Página inicial. */
    private boolean firstPage;
    /** Página final. */
    private boolean lastPage;
    /** Tamaño de página. */
    private int pageSize;
    /** Página actual. */
    private int currentPage;

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
