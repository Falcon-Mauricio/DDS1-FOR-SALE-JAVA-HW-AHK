package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inmuebles")
public class InmueblesController {
    private List<Inmueble> inmuebles;

    public InmueblesController(){
        this.inmuebles = new ArrayList<>();

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

        Inmueble inmuebleUno = new Casa();
        inmuebleUno.setId(1);
        inmuebleUno.setTamanioEnM2(124F);
        inmuebleUno.setCantAmbientes(1);
        inmuebleUno.setZona(zonaUna);

        Inmueble inmuebleDos = new PH();
        inmuebleDos.setId(2);
        inmuebleDos.setTamanioEnM2(200F);
        inmuebleDos.setCantAmbientes(5);
        inmuebleDos.setZona(zonaDos);

        Inmueble inmuebleTres = new Depto();
        inmuebleTres.setId(3);
        inmuebleTres.setTamanioEnM2(80F);
        inmuebleTres.setCantAmbientes(3);
        inmuebleTres.setZona(zonaTres);

        this.inmuebles.add(inmuebleUno);
        this.inmuebles.add(inmuebleDos);
        this.inmuebles.add(inmuebleTres);
    }

    @GetMapping
    public ModelAndView listadoDeInmuebles(Map<String, Object> model){
        model.put("title", "For Sale");
        model.put("inmuebles", this.inmuebles);
        return new ModelAndView("inmuebles", model);
    }
}