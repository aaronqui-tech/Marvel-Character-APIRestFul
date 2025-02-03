package org.aaronquitech.marvel.rest.repository;

import org.aaronquitech.marvel.rest.entity.CharacterLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de bitacora personajes
 *
 * @author Aaron Quinonez
 * @since 03/02/2025
 */
public interface CharacterLogRepository extends JpaRepository<CharacterLogEntity, Long> {

    Optional<List<CharacterLogEntity>> findAllByOrderByDatetimeDesc();
}
