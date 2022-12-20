package com.demo.service;

import java.util.ArrayList;
import com.demo.model.Avion;

public interface AvionService {

    public Avion creer(Avion avion);

    public ArrayList<Avion> lire();

    public Avion modifier(int id, Avion avion);

    public String supprimer(int id);

    public Avion getAvionById(int id);
}
