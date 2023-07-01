package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

    @GetMapping("/about")
    public ModelAndView getAbout(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about.html");
        return modelAndView;
    }

}
