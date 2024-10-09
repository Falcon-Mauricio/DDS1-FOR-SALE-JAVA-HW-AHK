package com.ahk.arg.forsale.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model) {
        model.addAttribute("errorMessage", "La página que buscas no existe.");
        return "404"; // Devuelve la plantilla 404.html
    }

    // Puedes manejar otros errores globalmente también
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Ocurrió un error inesperado.");
        return "404"; // Devuelve una página de error genérica
    }
}
