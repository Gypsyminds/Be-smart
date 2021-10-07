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
public class Facture {
   private  String id;
   private Client client ;
   private Categorie cat ;
   private  float montanttot;

    public Facture() {
    }
   

    public Facture(String id, Client client, Categorie cat, float montanttot) {
        this.id = id;
        this.client = client;
        this.cat = cat;
        this.montanttot = montanttot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    public float getMontanttot() {
        return montanttot;
    }

    public void setMontanttot(float montanttot) {
        this.montanttot = montanttot;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", client=" + client + ", cat=" + cat + ", montanttot=" + montanttot + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

 
       
       
   }

