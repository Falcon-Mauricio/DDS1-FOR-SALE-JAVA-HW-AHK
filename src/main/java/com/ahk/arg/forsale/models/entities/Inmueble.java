package com.ahk.arg.forsale.models.entities; //este archivo pertenece a este packete

import lombok.Getter;
import lombok.Setter;

//modificadore de acceso privete, protective, public
@Setter
@Getter
public abstract class Inmueble {
    protected Integer cantAmbientes;
    protected Float tamanioEnM2;
    private  Zona zona;

    public abstract float precio();

    public Float precioFinal() {
        return this.precio() + this.zona.getPrecio();
    }
}