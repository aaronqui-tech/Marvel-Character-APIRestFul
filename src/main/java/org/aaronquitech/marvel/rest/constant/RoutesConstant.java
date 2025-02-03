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
    /** Ruta para API */
    public static final String DOMAIN_CHARACTER_PATH = "${api.uri.domain.character}";
    /** Ruta para API */
    public static final String DOMAIN_CHARACTER_ID_PATH = "${api.uri.domain.character.id}";
    /** Ruta API externa Lista de Personajes. */
    public static final String EXTERNAL_API_CHARACTERS = "${marvel.path.character}";
    /** Ruta API externa Personaje por id. */
    public static final String EXTERNAL_API_CHARACTER_ID = "${marvel.path.character.id}";
}
