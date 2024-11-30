package com.obi.gastospersonales.utils;

import com.obi.gastospersonales.dto.IngresoDTO;
import com.obi.gastospersonales.entities.Ingreso;

public class ConversorUtils {
    public static IngresoDTO convertirAIngresoDTO(Ingreso ingreso) {
        return new IngresoDTO(
                ingreso.getId(),
                ingreso.getDescripcion(),
                ingreso.getFecha(),
                ingreso.getMonto(),
                ingreso.getCategoria() != null ? ingreso.getCategoria().getNombre() : "Sin categoría"
        );
    }
}
