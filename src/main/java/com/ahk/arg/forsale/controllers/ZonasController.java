package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zonas")
public class ZonasController {

    private List<Zona> zonas;

    public ZonasController(){
        this.zonas = new ArrayList<>();
        Zona zona1 = new Zona();
        zona1.setNombre("Recoleta");

        this.zonas.add(zona1);
    }
    @GetMapping
    public ResponseEntity<List<Zona>> buscarTodos() {
        return new ResponseEntity<>(this.zonas, HttpStatus.OK);
    }

    public ResponseEntity<Zona> crearZona(@RequestBody Zona zona){
        this.zonas.add(zona);
        return new ResponseEntity<>(zona, HttpStatus.CREATED);
    }

}
