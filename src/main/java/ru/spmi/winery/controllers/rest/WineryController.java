package ru.spmi.winery.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spmi.winery.entities.Winery;
import ru.spmi.winery.services.WineryService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/winery")
public class WineryController {

    @Autowired
    private WineryService wineryService;

    @GetMapping("/all")
    public ResponseEntity<List<Winery>> getAll() {
        return new ResponseEntity<>(wineryService.getAllWineries(), HttpStatus.OK);
    }


}
