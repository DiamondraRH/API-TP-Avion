package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Assurance;

import java.sql.Date;
import java.util.List;

@Repository
public interface AssuranceRepository  extends JpaRepository<Assurance, Integer>{

    @Query(value = "SELECT * FROM assurance WHERE date_expiration between Current_date AND (current_date + interval '1 months')", nativeQuery = true)
   public List<Assurance> findExpired1Month();

   @Query(value = "SELECT * FROM assurance WHERE date_expiration between Current_date AND (current_date + interval '3 months')", nativeQuery = true)
   public List<Assurance> findExpired3Month();
}
