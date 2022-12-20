package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import com.demo.model.Assurance;




public interface AssuranceService {
    
  
    public Assurance creer(Assurance assurance);
  
    public ArrayList<Assurance> lire();
  
    public Assurance modifier(Assurance assurance);
  
    public String supprimer(int id);
  
    public List <Assurance> findExpired1Month();

    public List <Assurance> findExpired3Month();
    
}
