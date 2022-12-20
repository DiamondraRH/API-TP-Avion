package com.demo.controller;


import java.sql.Date;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Assurance;
import com.demo.model.ErrorMessage;

import com.demo.service.AssuranceService;
import com.demo.service.JsonFormat;

@CrossOrigin("*")
@RestController
@RequestMapping("/assurance")
public class AssuranceController {
    
public final AssuranceService assuranceService;

public AssuranceController(AssuranceService assuranceService) {
    this.assuranceService = assuranceService;
}

public AssuranceService getAssuranceService() {
    return assuranceService;
}

@PostMapping("")
public ResponseEntity create(@RequestBody Assurance assurance, @PathVariable int idvoiture) {
    return JsonFormat.build(assuranceService.creer(assurance));
}

@PutMapping("")
public ResponseEntity update( @RequestBody Assurance assurance) {
    return JsonFormat.build(assuranceService.modifier(assurance));
}

@GetMapping("")
public ResponseEntity read() {
 return JsonFormat.build(assuranceService.lire());
}

@DeleteMapping("/{id}")
public ResponseEntity delete(@PathVariable int id) {
return JsonFormat.build(assuranceService.supprimer(id));
}
@GetMapping("/mois/3")
public ResponseEntity findExpired3Month() {
    List<Assurance> array = assuranceService.findExpired3Month();
    ResponseEntity res = null;
    if (array.size()>0){
        res=JsonFormat.build(array);
    }
    else{
        res=JsonFormat.build(new ErrorMessage(69, "NOT DATA FOUND"), HttpStatus.NO_CONTENT);
    }
    return res;


}
@GetMapping("/mois/1")
public ResponseEntity findExpired1Month() {
    List<Assurance> array = assuranceService.findExpired1Month();
    ResponseEntity res = null;
    if (array.size()>0){
        res=JsonFormat.build(array);
    }
    else{
        res=JsonFormat.build(new ErrorMessage(69, "NOT DATA FOUND"), HttpStatus.NO_CONTENT);
    }
    return res;
}
}
