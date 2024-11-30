package com.obi.gastospersonales.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final String FORMATO_FECHA = "dd/MM/yyyy";

    public static String formatoFecha(LocalDate fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        return fecha.format(formatter);
    }

    public static void parsearFecha(String fecha) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
    }

    public static boolean esFechaValida(String fecha) {
        try {
            parsearFecha(fecha);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
