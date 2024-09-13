package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Zona {
    private String nombre;
    private Float precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPrecio() {
        return precio;
    }
}
