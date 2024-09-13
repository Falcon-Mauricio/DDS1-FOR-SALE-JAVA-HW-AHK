package com.ahk.arg.forsale.models.entities;

import com.sun.jdi.FloatValue;

public class Depto extends Inmueble{

    @Override
    public float precio() {
        return Float.valueOf(350000 * super.cantAmbientes);
    }
}
