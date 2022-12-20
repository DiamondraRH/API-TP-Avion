package com.demo.service;

import java.util.ArrayList;

import com.demo.model.Kilometrage;

public interface KilometrageService {

    public Kilometrage creer(Kilometrage kilometrage);

    public ArrayList<Kilometrage> lire();

    public Kilometrage modifier(int id, Kilometrage kilometrage);

    public String supprimer(int id);

    public ArrayList<Kilometrage> voirParIdAvion(int id_avion);

}
