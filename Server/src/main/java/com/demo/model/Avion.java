package com.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @SequenceGenerator(name = "id_avion", sequenceName = "seq_idAvion", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idAvion")
    private int id;

    @NotNull
    @Column(name = "immatriculation", unique = true)
    private String immatriculation;

    @NotNull
    @Column(name = "places")
    private String places;

    @NotNull
    @Column(name = "portes")
    private String portes;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_marque")
    private Marque marque;

    @NotNull
    @Column(name = "image_avion")
    private String image;

    private Date expirationAssurance;

    public Avion() {
    }

    public Avion(int id, @NotNull String immatriculation, @NotNull String places, @NotNull String portes,
            @NotNull Marque marque, @NotNull String image) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.places = places;
        this.portes = portes;
        this.marque = marque;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getPortes() {
        return portes;
    }

    public void setPortes(String portes) {
        this.portes = portes;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getExpirationAssurance() {
        return expirationAssurance;
    }

    public void setExpirationAssurance(Date expirationAssurance) {
        this.expirationAssurance = expirationAssurance;
    }

}
