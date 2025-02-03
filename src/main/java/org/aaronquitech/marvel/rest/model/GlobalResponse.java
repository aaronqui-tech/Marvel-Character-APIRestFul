package org.aaronquitech.marvel.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.aaronquitech.marvel.rest.constant.PatternConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
@AllArgsConstructor
@Getter
@Setter
public class GlobalResponse<T> implements Serializable {
    /** Serial Version. */
    private static final long serialVersionUID = -2448150535100098479L;

    /** Propiedad estatus de http */
    private String status;

    /** Propiead codigo de respuesta. */
    private String code;

    /** Propiedad mensaje de respuesta. */
    private String message;

    /** Propiedad hora de la respuesta. */
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PatternConstant.DATE_FULL_PATTERN)
    private transient LocalDateTime timestamp;

    /** Objeto para la data de respuesta. */
    private transient T data;
}
