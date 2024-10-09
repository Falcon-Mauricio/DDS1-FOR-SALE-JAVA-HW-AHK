package com.ahk.arg.forsale.models.entities.operaciones.estados;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;

public interface EstadoOperacion {
    public void reservar(Inmueble inmueble, Cliente cliente, Empleado empleado);

    public void concretar(Inmueble inmueble, Cliente cliente, Empleado empleado);

    public String estado();

}
