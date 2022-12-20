package com.demo.repository;

import com.demo.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer> {
    @Query(value = "SELECT * FROM avion WHERE id_avion = :id", nativeQuery = true)
    public Avion getAvionById(@Param("id") int id);

}
