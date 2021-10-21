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
public class Client {
    private String nom ;
    private String prenom ;
    private Integer id ;
    private String adr ;

    public Client() {
    }
    

    public Client(String nom, String prenom, Integer id, String adr) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.adr = adr;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", adr=" + adr + '}';
    }

    public Client(Integer id) {
        this.id = id;
    }
    
}
