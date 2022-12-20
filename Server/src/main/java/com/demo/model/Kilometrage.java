package com.demo.model;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "kilometrage")
public class Kilometrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kilometrage")
    private int id;

    @NotNull
    @Column(name = "date_Kilometrage")
    private Date dateKilometrage;

    @NotNull
    @Column(name = "distance")
    private double distance;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_avion")
    private Avion avion;

    public Kilometrage() {
    }

    public Kilometrage(int id, Date dateKilometrage, Avion avion) {
        this.id = id;
        this.dateKilometrage = dateKilometrage;
        this.avion = avion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateKilometrage() {
        return dateKilometrage;
    }

    public void setDateKilometrage(Date dateKilometrage) {
        this.dateKilometrage = dateKilometrage;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double debut) {
        this.distance = debut;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

}
