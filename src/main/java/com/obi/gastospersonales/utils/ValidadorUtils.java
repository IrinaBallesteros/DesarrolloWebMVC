package com.obi.gastospersonales.utils;

public class ValidadorUtils {
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esNumeroPositivo(Double numero) {
        return numero != null && numero > 0;
    }

    public static boolean esIdValido(Long id) {
        return id != null && id > 0;
    }
}
