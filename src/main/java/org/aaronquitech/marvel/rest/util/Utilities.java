package org.aaronquitech.marvel.rest.util;

import org.aaronquitech.marvel.rest.constant.ApiConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Utilities {
    /**
     * Metodo para quitar saltos de linea de un string
     *
     * @param value valor {@code String}
     * @return String retorna {@code String} sin saltos de linea.
     */
    public String sanitizeString(String value) {
        return value.replace('\n', '_').replace(ApiConstant.BACK_SLASH, StringUtils.EMPTY);
    }
}
