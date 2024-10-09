package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PH extends Inmueble{

    @Override
    public String tipo() {
        return "PH";
    }

    @Override
    public float precio() {
        return 500000 + 14000 * super.tamanioEnM2;
    }
}
