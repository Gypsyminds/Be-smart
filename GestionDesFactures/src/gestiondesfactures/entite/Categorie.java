/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondesfactures.entite;

/**
 *
 * @author ZNJ
 */
public class Categorie {
    private String nom_cat;
    private String[] nomchap;
    private float prixcat ;

    public Categorie() {
    }
    

    public Categorie(String nom_cat, String[] nomchap, float prixcat) {
        this.nom_cat = nom_cat;
        this.nomchap = nomchap;
        this.prixcat = prixcat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String[] getNomchap() {
        return nomchap;
    }

    public void setNomchap(String[] nomchap) {
        this.nomchap = nomchap;
    }

    public float getPrixcat() {
        return prixcat;
    }

    public void setPrixcat(float prixcat) {
        this.prixcat = prixcat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "nom_cat=" + nom_cat + ", nomchap=" + nomchap + ", prixcat=" + prixcat + '}';
    }
    
}
