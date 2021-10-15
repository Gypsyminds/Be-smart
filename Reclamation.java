/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reclamations;

import java.sql.SQLException;
import Rec.services.RecServices;
import ClientRec.entites.ClientRec;
import Rec.services.MailSend;
import javax.mail.MessagingException;



public class Reclamation {
     public static void main(String[] args) throws SQLException, MessagingException {
        RecServices se = new RecServices();
        ClientRec A  = new ClientRec("77","KOUKOU","LAAJILI","27795513","koukouLAAAJILI@gmail.fr","problem!!");
        se.ajouterRéclamation(A);
        System.out.println(se.getClientRec());
        
        se.suppClients(A);
       
        se.ModiferClients(A);
        /*MailSend.SendMail("laajili.khouloud12@gmail.com");*/
       
       }
       
   
        
       
               
    
    }

