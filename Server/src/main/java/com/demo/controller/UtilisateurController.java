package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.model.*;
import com.demo.service.JsonFormat;
import com.demo.service.UtilisateurService;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisateurController {

    public final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Utilisateur utilisateur) {
        return JsonFormat.build(utilisateurService.creer(utilisateur));
    }

    @GetMapping("")
    public ResponseEntity read() {
        return JsonFormat.build(utilisateurService.lire());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Utilisateur personne) {
        return JsonFormat.build(utilisateurService.modifier(id, personne));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        return JsonFormat.build(utilisateurService.supprimer(id));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Utilisateur personne) {
        Utilisateur u = utilisateurService.login(personne);
        if (u != null) {
            u.setToken(utilisateurService.generateToken(u.getId()));
            utilisateurService.modifier(u.getId(), u);
            return JsonFormat.build(u,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorMessage(101, "Utilisateur not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/logout/{id}")
    public void logout(@PathVariable int id) {
        utilisateurService.logout(id);
    }
}
