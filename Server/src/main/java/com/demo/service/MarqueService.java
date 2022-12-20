package com.demo.service;

import java.util.ArrayList;

import com.demo.model.Marque;

public interface MarqueService {
    
    
    public Marque creer(Marque marque);

    public ArrayList<Marque> lire();

    public Marque modifier(int id, Marque marque);

    public String supprimer(int id);
}