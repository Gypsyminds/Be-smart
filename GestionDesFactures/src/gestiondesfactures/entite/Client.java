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
    private String id ;
    private String adr ;
    private String[] cat;
    private String[] factures ;

    public Client() {
    }
    

    public Client(String nom, String prenom, String id, String adr, String[] cat, String[] factures) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.adr = adr;
        this.cat = cat;
        this.factures = factures;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String[] getCat() {
        return cat;
    }

    public void setCat(String[] cat) {
        this.cat = cat;
    }

    public String[] getFactures() {
        return factures;
    }

    public void setFactures(String[] factures) {
        this.factures = factures;
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", adr=" + adr + ", cat=" + cat + ", factures=" + factures + '}';
    }
    
}
