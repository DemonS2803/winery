package ru.spmi.winery.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spmi.winery.entities.Vineyard;
import ru.spmi.winery.services.VineyardService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vineyard")
public class VineyardController {

    @Autowired
    private VineyardService vineyardService;

    @GetMapping("/all")
    public ResponseEntity<List<Vineyard>> getAllVineyards() {
        return new ResponseEntity<>(vineyardService.getAllVineyards(), HttpStatus.OK);
    }

}
