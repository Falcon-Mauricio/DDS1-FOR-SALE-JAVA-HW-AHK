package com.ahk.arg.forsale.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello AHK!!!";
    }
    @GetMapping("/hello/{nombre}")
    public String helloTo(@PathVariable String nombre){
        return "Hello " + nombre;
    }

    @GetMapping("/hello-complex")
    public String helloComplex(
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "apellido", required = false) String apellido)
    {
        return "Hola " + nombre + " " + apellido;
    }
}