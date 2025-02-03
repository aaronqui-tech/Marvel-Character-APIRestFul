package org.aaronquitech.marvel.rest.configuration;

import org.aaronquitech.marvel.rest.constant.ApiConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Clase configuracion para lectura de properties
 *
 * @author Aaron Quiñonez
 * @since 30/01/2025
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = ApiConstant.MARVEL_KEY_PREFIX)
public class KeyMarvelProperties {
    /** Propiedad externa llave publica. */
    private String publicKey;

    /** Propiedad externa llave privada. */
    private String privatekey;
}
