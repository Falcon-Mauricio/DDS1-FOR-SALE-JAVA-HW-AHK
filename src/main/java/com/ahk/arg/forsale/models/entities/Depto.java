package com.ahk.arg.forsale.models.entities;

import com.sun.jdi.FloatValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Depto extends Inmueble{

    @Override
    public String tipo() {
        return "Depto";
    }

    @Override
    public float precio() {
        return Float.valueOf(350000 * super.cantAmbientes);
    }
}
