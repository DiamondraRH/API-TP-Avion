package com.demo.service;

import java.util.ArrayList;

import com.demo.model.Utilisateur;

public interface UtilisateurService {

    public Utilisateur creer(Utilisateur utilisateur);

    public ArrayList<Utilisateur> lire();

    public Utilisateur modifier(int id, Utilisateur utilisateur);

    public String supprimer(int id);

    public Utilisateur login(Utilisateur utilisateur);

    public String generateToken(int idUtilisateur);

    public void logout(int idUtilisateur);
}