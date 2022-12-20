package com.demo.model;

import java.sql.Date;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "assurance")

public class Assurance {

    @Id
    @SequenceGenerator(name = "id_assurance", sequenceName = "seq_id_assurance", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "idAssurance")
    private int id;

    
    
    @Column(name = "date_obtention")
    private Date dateObtention;
    

    @Column(name = "date_expiration")
    private Date dateExpiration;
    
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_avion")
    private Avion avion;

    

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Date return the dateObtention
     */
    public Date getDateObtention() {
        return dateObtention;
    }

    /**
     * @param dateObtention the dateObtention to set
     */
    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    /**
     * @return Date return the dateExpiration
     */
    public Date getDateExpiration() {
        return dateExpiration;
    }

    /**
     * @param dateExpiration the dateExpiration to set
     */
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    /**
     * @return Avion return the avion
     */
    public Avion getAvion() {
        return avion;
    }

    /**
     * @param avion the avion to set
     */
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

}
