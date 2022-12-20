package com.demo.service.implementation;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.demo.model.Kilometrage;
import com.demo.repository.KilometrageRepository;
import com.demo.service.KilometrageService;

@Service
public class KilometrageServiceImpl implements KilometrageService {

    public final KilometrageRepository kilometrageRepository;

    public KilometrageServiceImpl(KilometrageRepository kilometrageRepository) {
        this.kilometrageRepository = kilometrageRepository;
    }

    @Override
    public Kilometrage creer(Kilometrage kilometrage) {
        // TODO Auto-generated method stub
        return kilometrageRepository.save(kilometrage);
    }

    @Override
    public ArrayList<Kilometrage> lire() {
        // TODO Auto-generated method stub
        return (ArrayList<Kilometrage>) kilometrageRepository.findAll();
    }

    @Override
    public Kilometrage modifier(int id, Kilometrage kilometrage) {
        // TODO Auto-generated method stub
        return kilometrageRepository.findById(id).map(k -> {
            k.setAvion(kilometrage.getAvion());
            k.setDateKilometrage(kilometrage.getDateKilometrage());
            k.setDistance(kilometrage.getDistance());
            return kilometrageRepository.save(k);
        }).orElseThrow(() -> new RuntimeException("Kilometrage non trouve"));
    }

    @Override
    public String supprimer(int id) {
        // TODO Auto-generated method stub
        kilometrageRepository.deleteById(id);
        return "Kilomettrage supprimer";
    }

    @Override
    public ArrayList<Kilometrage> voirParIdAvion(int id_avion) {
        // TODO Auto-generated method stub
        return (ArrayList<Kilometrage>) kilometrageRepository.findByIdAvion(id_avion);
    }
}
