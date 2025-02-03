package org.aaronquitech.marvel.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aaronquitech.marvel.rest.constant.DataBaseConstant;

import java.time.LocalDateTime;

/**
 * Entity de bitacora de consulta personajes
 *
 * @author Aaron Quinonez
 * @since 03/02/2025
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = DataBaseConstant.TABLE_CHARACTER_LOG)
public class CharacterLogEntity {
    /** Id principal */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConstant.COLUMN_LOG_ID)
    private Long id;

    /** Propiedad de Proceso. */
    @Column(name = DataBaseConstant.COLUMN_API_ENDPOINT)
    private String apiEndpoint;

    /** Propiedad Canal. */
    @Column(name = DataBaseConstant.COLUMN_DATE_TIME)
    private LocalDateTime datetime;
}
