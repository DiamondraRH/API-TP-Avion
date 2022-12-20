package com.demo.repository;

import com.demo.model.Kilometrage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KilometrageRepository extends JpaRepository<Kilometrage, Integer> {

    @Query(value = "SELECT * FROM kilometrage WHERE id_avion = :id_avion", nativeQuery = true)
    public List<Kilometrage> findByIdAvion(@Param("id_avion") int id_avion);

}
