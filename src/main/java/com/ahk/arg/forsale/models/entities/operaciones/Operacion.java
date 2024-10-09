package com.ahk.arg.forsale.models.entities.operaciones;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.operaciones.estados.EstadoOperacion;
import com.ahk.arg.forsale.models.entities.operaciones.estados.Publicada;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Operacion {
    protected Inmueble inmueble;
    private EstadoOperacion estado;

    public Operacion(){
        this.estado = new Publicada();
    }

    public abstract Float calcularComisionPara(Empleado empleado);

    public void reservar(Empleado empleado, Cliente cliente) {
        this.estado.concretar(this.inmueble, cliente, empleado);
    }

    public void concretar(Empleado empleado, Cliente cliente) {
        this.estado.reservar(this.inmueble, cliente, empleado);
    }

    public abstract String tipo();
}
