package com.demo.repository;

import com.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    @Query(value = "SELECT * FROM utilisateur WHERE email = :email and mdp = md5(:mdp)", nativeQuery = true)
    public Utilisateur login(@Param("email") String email, @Param("mdp") String mdp);
    
    @Query(value = "SELECT MD5(cast(now() AS TEXT) || (SELECT email FROM utilisateur WHERE id_utilisateur = :id_utilisateur))", nativeQuery = true)
    public String generateToken(@Param("id_utilisateur") int id);

    @Modifying
    @Query(value = "UPDATE utilisateur set token = null WHERE id_utilisateur = :id_utilisateur", nativeQuery = true)
    @Transactional
    public void logout(@Param("id_utilisateur") int id);
}
