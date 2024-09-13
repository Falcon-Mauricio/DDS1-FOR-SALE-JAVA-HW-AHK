package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Casa extends Inmueble {
    private Float valor;
//super hace referencia a la clase padre
    @Override
    public float precio() {
        return this.valor;
    }
}
