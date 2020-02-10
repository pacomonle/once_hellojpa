package com.alfonsotienda.holaspring.controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * MainController
 */

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String holaMundo(@RequestParam("nombre") String name, 
                            @RequestParam("edad") Integer edad){
        return "Hola "+name + " tienes "+ edad+ "años";
    }

    @GetMapping("/ingles")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/nuevo")
    public ModelAndView helloHTML(){
        ModelAndView respuesta = new ModelAndView("hello");
        String msg = "Hola Mundo html";
        respuesta.addObject("mensaje", msg);
        return respuesta;
    }

    
}