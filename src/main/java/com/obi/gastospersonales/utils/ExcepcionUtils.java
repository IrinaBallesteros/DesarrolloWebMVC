package com.obi.gastospersonales.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcepcionUtils {
    private static final Logger logger = LoggerFactory.getLogger(ExcepcionUtils.class);

    public static void registrarError(String mensaje, Exception e) {
        logger.error(mensaje, e);
    }

    public static void registrarAdvertencia(String mensaje) {
        logger.warn(mensaje);
    }

}
