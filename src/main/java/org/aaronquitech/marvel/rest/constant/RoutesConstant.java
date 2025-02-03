package org.aaronquitech.marvel.rest.constant;

/**
 * Clase de constantes para rutas de los EndPoints
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
public abstract class RoutesConstant {
    /** Ruta base del proyecto */
    public static final String BASE_PATH = "${api.uri.basepath}";
    /** Ruta para API - Characters. */
    public static final String DOMAIN_CHARACTER_PATH = "${api.uri.domain.character}";
    /** Ruta para API - Character ID. */
    public static final String DOMAIN_CHARACTER_ID_PATH = "${api.uri.domain.character.id}";
    /** Ruta para API - Log. */
    public static final String DOMAIN_CHARACTER_LOG_PATH = "${api.uri.domain.character.log}";
}
