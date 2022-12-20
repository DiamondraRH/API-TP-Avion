package com.demo.service.implementation;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.demo.model.Utilisateur;
import com.demo.repository.UtilisateurRepository;
import com.demo.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
        
    }

    @Override
    public Utilisateur creer(Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public ArrayList<Utilisateur> lire() {
        // TODO Auto-generated method stub
        return (ArrayList<Utilisateur>) utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur modifier(int id, Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        return utilisateurRepository.findById(id).map(a -> {
            a.setEmail(utilisateur.getEmail());
            a.setMdp(utilisateur.getMdp());
            a.setToken(utilisateur.getToken());
            return utilisateurRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouve"));
    }

    @Override
    public String supprimer(int id) {
        // TODO Auto-generated method stub
        utilisateurRepository.deleteById(id);
        return "Utilisateur supprimer";
    }

    @Override
    public Utilisateur login(Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        return utilisateurRepository.login(utilisateur.getEmail(), utilisateur.getMdp());
    }

    @Override
    public String generateToken(int idutilisateur) {
        return utilisateurRepository.generateToken(idutilisateur);
    }

    @Override
    public void logout(int idutilisateur) {
        utilisateurRepository.logout(idutilisateur);
    }
}
