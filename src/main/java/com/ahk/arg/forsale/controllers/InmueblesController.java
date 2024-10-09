package com.ahk.arg.forsale.controllers;

import ch.qos.logback.core.net.server.Client;
import com.ahk.arg.forsale.models.entities.*;
import com.ahk.arg.forsale.models.entities.operaciones.Alquiler;
import com.ahk.arg.forsale.models.entities.operaciones.Venta;
import com.ahk.arg.forsale.models.entities.operaciones.estados.Publicada;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inmuebles")
public class InmueblesController {
    private List<Inmueble> inmuebles;
    private List<Empleado> empleados;
    private List<Cliente> clientes;
    public InmueblesController(){
        this.inmuebles = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();

        Empleado empleadoUno = new Empleado();
        empleadoUno.setNombre("Mauricio");
        empleadoUno.setApellido("Falcon");
        empleadoUno.setId(1);

        Empleado empleadoDos = new Empleado();
        empleadoDos.setNombre("Nachito");
        empleadoDos.setApellido("Brandt");
        empleadoDos.setId(2);

        Empleado empleadoTres = new Empleado();
        empleadoTres.setNombre("Lucas");
        empleadoTres.setApellido("Portillo");
        empleadoTres.setId(3);

        Cliente clienteUno = new Cliente();
        clienteUno.setNombre("German");
        clienteUno.setApellido("Moreno");
        clienteUno.setId(1);

        Cliente clienteDos = new Cliente();
        clienteDos.setNombre("Fernanda");
        clienteDos.setApellido("Baez");
        clienteDos.setId(2);

        Cliente clienteTres = new Cliente();
        clienteTres.setNombre("Marino");
        clienteTres.setApellido("Motta");
        clienteTres.setId(3);

        Casa inmuebleUno = new Casa();
        inmuebleUno.setId(1);
        inmuebleUno.setTamanioEnM2(124F);
        inmuebleUno.setCantAmbientes(1);
        inmuebleUno.setOperacion(new Alquiler());
        inmuebleUno.setEstadoOperacion(new Publicada());
        inmuebleUno.setValor(100F);
        inmuebleUno.getOperacion().setInmueble(inmuebleUno);

        Inmueble inmuebleDos = new PH();
        inmuebleDos.setId(2);
        inmuebleDos.setTamanioEnM2(200F);
        inmuebleDos.setCantAmbientes(5);
        inmuebleDos.setOperacion(new Alquiler());
        inmuebleDos.setEstadoOperacion(new Publicada());

        Inmueble inmuebleTres = new Depto();
        inmuebleTres.setId(3);
        inmuebleTres.setTamanioEnM2(80F);
        inmuebleTres.setCantAmbientes(3);
        inmuebleTres.setOperacion(new Venta());
        inmuebleTres.setEstadoOperacion(new Publicada());

        this.inmuebles.add(inmuebleUno);
        this.inmuebles.add(inmuebleDos);
        this.inmuebles.add(inmuebleTres);
        this.empleados.add(empleadoUno);
        this.empleados.add(empleadoDos);
        this.empleados.add(empleadoTres);
        this.clientes.add(clienteUno);
        this.clientes.add(clienteDos);
        this.clientes.add(clienteTres);
    }

    @GetMapping
    public ModelAndView listadoDeInmuebles(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("inmuebles", this.inmuebles);
        return new ModelAndView("inmuebles", model);
    }

    @GetMapping("/crear")
    public ModelAndView formularioDeCrear(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("zonas", this.inmuebles);
        return new ModelAndView("formularioInmueble", model);
    }

    @PostMapping("/casa/guardar")
    public RedirectView guardarCasa(@ModelAttribute Casa casa) {
        // Lógica para guardar la casa
        inmuebles.add(casa);
        return new RedirectView("/inmuebles");
    }

    @PostMapping("/ph/guardar")
    public ModelAndView guardarPH(@ModelAttribute PH ph, Map<String, Object> model) {
        // Lógica para guardar el PH
        inmuebles.add(ph);
        return new ModelAndView("/inmuebles");
    }

    @PostMapping("/depto/guardar")
    public ModelAndView guardarDepto(@ModelAttribute Depto depto, Map<String, Object> model) {
        // Lógica para guardar el departamento
        inmuebles.add(depto);
        return new ModelAndView("/inmuebles");
    }
    //crear los metodo en los controller listado de clientes y de empleados
    @GetMapping("/{id}/reservar")
    public ModelAndView formularioDeReservar(@PathVariable Integer id, Map<String, Object> model){
        model.put("empleados", this.empleados);
        model.put("clientes", this.clientes);
        model.put("inmueble", id);
        model.put("title", "For Sale");
        return new ModelAndView("formularioConcretar", model);
    }

    @PostMapping("/{id}/reservado")
    public RedirectView guardarReserva(
            @PathVariable Integer id,
            @RequestParam Integer empleadoID,
            @RequestParam Integer clienteID){
        System.out.println("Hola estoy aca");
        Inmueble inmueble = this.inmuebles.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        System.out.println("Hola estoy aca1");

        Empleado empleadoObtenido = this.empleados.stream().filter(e -> e.getId().equals(empleadoID)).findFirst().get();
        System.out.println("Hola estoy aca2");

        Cliente clienteObtendio = this.clientes.stream().filter(c -> c.getId().equals(clienteID)).findFirst().get();
        System.out.println("Hola estoy aca3");

        empleadoObtenido.registrarReserva(clienteObtendio, inmueble);
        System.out.println("Hola estoy aca4");
        return new RedirectView("/inmuebles");
    }


    @GetMapping("/{id}/concretar")
    public ModelAndView formularioDeConcretar(@PathVariable Integer id, Map<String, Object> model) {
        model.put("empleados", this.empleados);
        model.put("clientes", this.clientes);
        model.put("inmueble", id);
        model.put("title", "For Sale");
        return new ModelAndView("formularioConcretar", model);
    }
}