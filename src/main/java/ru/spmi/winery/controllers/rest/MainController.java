package ru.spmi.winery.controllers.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/check")
    public String index() {
        return "Welcome to Winery!";
    }

}
