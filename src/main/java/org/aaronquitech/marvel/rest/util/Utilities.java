package org.aaronquitech.marvel.rest.util;

import org.aaronquitech.marvel.rest.constant.ApiConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
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

    /**
     * Obtiene la pagina actual.
     *
     * @param pageable datos de paginación
     * @return pagina actual
     */
    public int getCurrentPage(Pageable pageable) {
        int page = pageable.getPageNumber();
        if (pageable.getPageNumber() != ApiConstant.INT_ZERO_VALUE) {
            page -= ApiConstant.INT_ONE_VALUE;
        }
        return page;
    }
}
