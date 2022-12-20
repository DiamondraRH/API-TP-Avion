package com.demo.service.implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.demo.model.Marque;
import com.demo.repository.MarqueRepository;
import com.demo.service.MarqueService;

@Service
public class MarqueServiceImpl implements MarqueService {

    private final MarqueRepository marqueRepository;

    public MarqueServiceImpl(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    @Override
    public Marque creer(Marque marque) {
        // TODO Auto-generated method stub
        return marqueRepository.save(marque);
    }

    @Override
    public ArrayList<Marque> lire() {
        // TODO Auto-generated method stub
        return (ArrayList<Marque>) marqueRepository.findAll();
    }

    @Override
    public Marque modifier(int id, Marque marque) {
        // TODO Auto-generated method stub
        return marqueRepository.findById(id).map(m -> {
            m.setIntitule(marque.getIntitule());
            return marqueRepository.save(m);
        }).orElseThrow(() -> new RuntimeException("Marque non trouve"));
    }

    @Override
    public String supprimer(int id) {
        // TODO Auto-generated method stub
        marqueRepository.deleteById(id);
        return "Marque supprimer";
    }
}