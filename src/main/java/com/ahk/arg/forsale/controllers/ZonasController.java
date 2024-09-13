package com.ahk.arg.forsale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zonas")
public class ZonasController {

    @GetMapping
    public ModelAndView listadoDeZonas(){
        return new ModelAndView("zonas");
    }
}