package ru.spmi.winery.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MainController {

    @GetMapping("")
    public String index() {
        return "Welcome to Winery!";
    }

}
