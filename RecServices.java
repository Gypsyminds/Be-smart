
package Rec.services;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import Client.cnx.MyConnection;
import ClientRec.entites.ClientRec;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


        


public class RecServices {
    private final Connection cnxx;

    public RecServices() {
        cnxx = MyConnection.getMycnx().getConnection();
    }
    /*
    public void ajouter"INSERT INTO client_réc(nom,prénom,tel,émail,description,date) value ('"+C.getNom()+"','"+C.getPrénom()+"','"+C.getTel()+"','"+C.getÉmail()+"','"+C.getDescription()+"','"+C.getDate()+'");
            Statement st = (Statement) cnxx.createStatement();
            st.executeUpdate(req);
            System.out.println(" votre réclamation a été ajoutée avec succées   ");
            } 
        catch (SQLException ex) 
            {
          System.err.println(ex.getMessage());
            }
    }
    */
     public void ajouterRéclamation( ClientRec A){
         
         try {
      
            String req ="INSERT INTO ClientRec(id,nom,prenom,tel,email,description) value (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(req);
            pst.setString(1,A.getId());
            pst.setString(2,A.getNom());
            pst.setString(3,A.getPrenom());
            pst.setString(4,A.getTel());
            pst.setString(5,A.getEmail());
            pst.setString(6,A.getDescription());
            pst.executeUpdate();
            System.out.println(" votre réclamation a été ajoutée avec succées   ");
            } 
        catch (SQLException ex) 
            {
          System.err.println(ex.getMessage());
            }
     }
/*
     private  void Timestamp() {
      
//To change body of generated methods, choose Tools | Templates.
    }
   */
     
     public List<ClientRec> getClientRec() throws SQLException{
          List<ClientRec> Clients = new ArrayList<>();
        try {
           
            String req =" Select* from ClientRec";
            Statement st = (Statement) cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next())
            {
              ClientRec A= new ClientRec( rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)); 
              Clients.add(A);
            }
            }
       
        
catch (SQLException ex) {
          System.out.println(ex.getMessage()); 
        }
           return Clients;
     }

   public  void suppClients (ClientRec A){
  
        try {
           
            
            String rec = "DELETE FROM ClientRec WHERE id='77' ";
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(rec);
           
            pst.executeUpdate();
         
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        }
   }
     
   
   
   
   
   public void ModiferClients(ClientRec  e) {
		try {
	    	  String req="UPDATE ClientRec SET email='BB' WHERE email='koukouLAAAJILI@gmail.fr'";
                  PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(req);
	 
	    	
	     pst.executeUpdate();
	    	 /* pst.executeQuery(req);*/
		} // Try
  	  catch (SQLException ex)
	  {
		 System.err.println(ex.getMessage());
	}
   }
   
}
   














/*
 * To change this license header, choose License Headers in Project Properties.
 * To changehis template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Guide Info
 */
