package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Marque;
import com.demo.service.JsonFormat;
import com.demo.service.MarqueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/marques")
public class MarqueController {

    public final MarqueService marqueService;

    public MarqueController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Marque marque) {
        return JsonFormat.build(marqueService.creer(marque));
    }

    @GetMapping()
    public ResponseEntity read() {
        return JsonFormat.build(marqueService.lire());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Marque marque) {
        return JsonFormat.build(marqueService.modifier(id, marque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return JsonFormat.build(marqueService.supprimer(id));
    }

}
