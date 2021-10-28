/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondesfactures.entite;

import java.util.Objects;

/**
 *
 * @author ZNJ
 */
public class FactureDto {
   private  Integer id;
   private  Integer idClient;
   private String nom ;
   private String prenom ;
   private String cat ;
   private  float  montant;

    public FactureDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "FactureDto{" + "id=" + id + ", idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", cat=" + cat + ", montant=" + montant + '}';
    }

  
 
       
       
   }

