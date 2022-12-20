package com.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Kilometrage;
import com.demo.service.JsonFormat;
import com.demo.service.KilometrageService;
import com.demo.service.AvionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/voitures/{idvoiture}/kilometrages")
public class KilometrageController {

    public final KilometrageService kilometrageService;
    public final AvionService voitureService;

    public KilometrageController(KilometrageService kilometrageService, AvionService voitureService) {
        this.kilometrageService = kilometrageService;
        this.voitureService = voitureService;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Kilometrage kilometrage, @PathVariable int idvoiture) {
        return JsonFormat.build(kilometrageService.creer(kilometrage));

    }

  @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Kilometrage kilometrage) {
        return JsonFormat.build(kilometrageService.modifier(id, kilometrage)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return JsonFormat.build(kilometrageService.supprimer(id)) ;
    }

}
