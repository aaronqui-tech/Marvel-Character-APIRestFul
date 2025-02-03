package org.aaronquitech.marvel.rest.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aaronquitech.marvel.rest.constant.DataBaseConstant;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Modelo de datos para Bitacora
 *
 * @author Aaron Quinonez
 * @since 03/02/2025
 */
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
    private LocalDateTime datetime;
}
