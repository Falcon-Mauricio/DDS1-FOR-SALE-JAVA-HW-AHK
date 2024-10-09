package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zonas")
public class ZonasController {
    private List<Zona> zonas;

    public ZonasController(){
        this.zonas = new ArrayList<>();

        Zona zonaUna = new Zona();
        zonaUna.setId(1);
        zonaUna.setNombre("Palermo");
        zonaUna.setPrecio(150F);
        Zona zonaDos = new Zona();
        zonaDos.setId(2);
        zonaDos.setNombre("Adrogue");
        zonaDos.setPrecio(150F);
        Zona zonaTres = new Zona();
        zonaTres.setId(3);
        zonaTres.setNombre("Termpley");
        zonaTres.setPrecio(150F);
        Zona zonaCuatro = new Zona();
        zonaCuatro.setId(4);
        zonaCuatro.setNombre("Moreno");
        zonaCuatro.setPrecio(150F);

        this.zonas.add(zonaUna);
        this.zonas.add(zonaDos);
        this.zonas.add(zonaTres);
        this.zonas.add(zonaCuatro);
    }

    @GetMapping
    public ModelAndView listadoDeZonas(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("zonas", this.zonas);
        return new ModelAndView("zonas", model);
    }

    @GetMapping("/crear")
    public ModelAndView formularioDeCrear(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("zonas", this.zonas);
        return new ModelAndView("formularioZona", model);
    }

    @PostMapping("/guardar")
    public ModelAndView guardarZona(@ModelAttribute Zona zona, Map<String, Object> model) {
        this.zonas.add(zona);
        model.put("title", "For Sale");
        return new ModelAndView("exitoAlCrear", model);
    }
/*
    @PostMapping("/guardar")
    public RedirectView CrearNuevaZona(@RequestParam("nombre") String nombre,
                                            @RequestParam("precio") Float precio,
                                            @RequestParam("id") Integer id,
                                            Map<String, Object> model) {
        Zona nuevaZona = new Zona();
        nuevaZona.setId(id);
        nuevaZona.setNombre(nombre);
        nuevaZona.setPrecio(precio);

        this.zonas.add(nuevaZona);

        model.put("title", "For Sale");
        model.put("zonas", this.zonas);
        return new RedirectView("/zonas");
    }
    */
}