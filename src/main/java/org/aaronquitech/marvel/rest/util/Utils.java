package org.aaronquitech.marvel.rest.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * Clase de Utilerias
 *
 * @author Aaron Quinonez
 * @since 01/02/2025
 */
@Component
public class Utils {
    /**
     * Metodo para generar MD5
     *
     * @param keys datos para hash
     * @return hash {@link String}
     */
    public String generateHash(String keys) {
        return DigestUtils.md5DigestAsHex(keys.getBytes(StandardCharsets.UTF_8));
    }
}