package com.demo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.ErrorMessage;
import com.demo.model.Kilometrage;
import com.demo.model.Avion;
import com.demo.service.JsonFormat;
import com.demo.service.KilometrageService;
import com.demo.service.AvionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/avions")
public class AvionController {

    public final AvionService avionService;
    public final KilometrageService kilometrageService;

    public AvionController(AvionService avionService, KilometrageService kilometrageService) {
        this.avionService = avionService;
        this.kilometrageService = kilometrageService;
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody Avion avion) {
        return JsonFormat.build(avionService.creer(avion));

    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Avion>> read() {
        return new ResponseEntity<ArrayList<Avion>>(avionService.lire(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable int id) {
        return JsonFormat.build(avionService.getAvionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Avion avion) {
        return JsonFormat.build(avionService.modifier(id, avion));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return JsonFormat.build(kilometrageService.supprimer(id));

    }

    @GetMapping("/{id}/kilometrages")
    public ResponseEntity findByIdAvion(@PathVariable int id) {
        ArrayList<Kilometrage> array = kilometrageService.voirParIdAvion(id);
        ResponseEntity res = null;
        if (array.size() > 0) {
            res = JsonFormat.build(array);
        } else {
            res = JsonFormat.build(new ErrorMessage(69, "NOT DATA FOUND"), HttpStatus.NO_CONTENT);
        }
        return res;
    }
}
