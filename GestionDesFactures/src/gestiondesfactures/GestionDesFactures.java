/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondesfactures;

import gestiondesfactures.entite.Categorie;
import gestiondesfactures.entite.Client;
import gestiondesfactures.entite.Facture;
import gestiondesfactures.utis.MyConnection;
import service.ServiceFacture;

/**
 *
 * @author ZNJ
 */
public class GestionDesFactures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnection.getMyCnx();
        Facture f=new Facture();
        Client c=new Client();
          c.setId(1);
//        c.setAdr("aeadefzafzafaf");
//        c.setNom("mehdi");
//        c.setPrenom("gassem");
        f.setClient(c);
        Categorie cat=new Categorie();
        cat.setNomchap("tunis");
        f.setCat(cat);
        f.setMontanttot(23200f);
        ServiceFacture sv=new ServiceFacture(); 
        sv.ajouterFacture1(f);
//        sv.getFactures();
//        System.out.println(sv.getFactures());
//        sv.supprimerFacture1(558);
//sv.modifierFacture1(559, 1, "tunis", 203);
       
        
        
        
    

    }
    
    
}
