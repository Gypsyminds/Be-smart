/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondesfactures;

import gestiondesfactures.entite.Client;
import gestiondesfactures.entite.Facture;
import gestiondesfactures.utis.MyConnection;

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
        f.setClient(c);
        
    

    }
    
    
}
