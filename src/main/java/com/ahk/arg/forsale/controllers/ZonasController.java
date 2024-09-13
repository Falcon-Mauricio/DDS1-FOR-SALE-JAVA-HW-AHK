package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView CrearZona(Map<String, Object> model){
        model.put("title", "For Sale");
        return new ModelAndView("CrearZona", model);
    }
}