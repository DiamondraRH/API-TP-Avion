package com.demo.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "marque")
public class Marque {
    @Id
    @SequenceGenerator(name = "id_marque", sequenceName = "seq_id_marque", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_marque")
    @Column(name = "id_marque")
    private int id;

    @NotNull
    @Column(name = "intitule", unique = true)
    private String intitule;    


    public Marque() {
    }

    public Marque(int id, @NotNull String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

}
