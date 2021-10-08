/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package réclamation;

import java.sql.SQLException;
import réc.parent.services.RéclamationService;
import réc.parent.entites.client_réc;
/**
 *
 * @author Guide Info
 */
public class Réclamation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        RéclamationService se = new RéclamationService();
        client_réc CE   = new client_réc("khouloud","laajli","laajilikhoulou@gmail.com","27158236","jgjhf");
        
        /*se.ajouterRéclamation(CE);
        /*MyConnection.getMycnx();
        // TODO code application logic here//
        
    }*/
        System.out.println(se.getClient_réc());
    }
}
