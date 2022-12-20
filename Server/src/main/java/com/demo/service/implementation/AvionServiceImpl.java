package com.demo.service.implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.demo.model.Avion;
import com.demo.repository.AvionRepository;
import com.demo.service.AvionService;

@Service
public class AvionServiceImpl implements AvionService {

    private final AvionRepository avionRepository;

    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    @Override
    public Avion creer(Avion avion) {
        // TODO Auto-generated method stub
        return avionRepository.save(avion);
    }

    @Override
    public ArrayList<Avion> lire() {
        // TODO Auto-generated method stub
        return (ArrayList<Avion>) avionRepository.findAll();
    }

    @Override
    public Avion modifier(int id, Avion avion) {
        // TODO Auto-generated method stub
        return avionRepository.findById(id).map(a -> { 
            a.setImmatriculation(avion.getImmatriculation());
            a.setMarque(avion.getMarque());
            return avionRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Avion non trouve"));
    }

    @Override
    public String supprimer(int id) {
        // TODO Auto-generated method stub
        avionRepository.deleteById(id);
        return "Avion supprimer";
    }

    @Override
    public Avion getAvionById(int id) {
        return avionRepository.getAvionById(id);
    }


}
