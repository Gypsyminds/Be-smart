/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package réc.parent.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.ResultSet;
import réc.parent.cnx.MyConnection;
import réc.parent.entites.client_réc;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

        


public class RéclamationService {
    private final Connection cnxx;

    public RéclamationService() {
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
     public void ajouterRéclamation( client_réc C){
         
         try {
      
            String req ="INSERT INTO client_réc(nom,prénom,tel,émail,description) value (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(req);
            pst.setString(1,C.getNom());
            pst.setString(2,C.getPrénom());
            pst.setString(3,C.getTel());
            pst.setString(4,C.getÉmail());
            pst.setString(5,C.getDescription());
           
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
     
     public List<client_réc> getClient_réc() throws SQLException{
          List<client_réc> client_réclamation = new ArrayList<>();
        try {
           
            String req =" Select* from client_réc";
            Statement st = (Statement) cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next())
            {
              client_réc C = new client_réc(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6)); 
              client_réclamation.add(C);
            }
            }
       
        
catch (SQLException ex) {
          System.out.println(ex.getMessage()); 
        }
           return client_réclamation;
     }

   
     
}
