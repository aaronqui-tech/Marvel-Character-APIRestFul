package org.aaronquitech.marvel.rest.enums;

import lombok.Getter;

/**
 * Enum de codigos y mensajes de error
 *
 * @author Aaron Quinonez
 * @since 02/02/2025
 */
@Getter
public enum ErrorMessageEnum {
    UNKNOWN_ERROR("MCS-E100", "Ocurrió error desconocido."),
    NOT_DATA_FOUND("MCS-E101", "No se encontraron datos."),
    SERIALIZABLE_JSON_ERROR("MCS-E102", "Error al intentar serializar JSON");

    /** Codigo del error */
    private final String code;
    /** Mensaje de Error */
    private final String message;

    /**
     * Contructor de la clase.
     *
     * @param code    Codigo de error de tipo {@code String}
     * @param message Mensaje de error de tipo {@code String}
     */
    ErrorMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
