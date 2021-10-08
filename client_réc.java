/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package réc.parent.entites;

import java.util.Objects;

/**
 *
 * @author Guide Info
 */
public class client_réc {

    private String nom;
    private String prénom;
    private String tel;
    private String émail;
    private timestamp date;
    private String description;
    
    public client_réc() {
    }

    
    
   

    public client_réc(String nom, String prénom, String tel, String émail, String description) {
        this.nom = nom;
        this.prénom = prénom;
        this.tel = tel;
        this.émail = émail;
        this.description = description;
    }

    public client_réc(String nom, String prénom, String tel, String émail, timestamp date, String description) {
        this.nom = nom;
        this.prénom = prénom;
        this.tel = tel;
        this.émail = émail;
        this.date = date;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getÉmail() {
        return émail;
    }

    public void setÉmail(String émail) {
        this.émail = émail;
    }

    public timestamp getDate() {
        return date;
    }

    public void setDate(timestamp date) {
        this.date = date;
    }

        

  public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    @Override
  

  
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prénom);
        hash = 97 * hash + Objects.hashCode(this.tel);
        hash = 97 * hash + Objects.hashCode(this.émail);
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
        final client_réc other = (client_réc) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prénom, other.prénom)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.émail, other.émail)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
      
        return true;
    }

    @Override
    public String toString() {
        return "client_r\u00e9c{" + "nom=" + nom + ", pr\u00e9nom=" + prénom + ", tel=" + tel + ", \u00e9mail=" + émail + ",  description=" + description + '}';
    }

}


 

 

        
    



