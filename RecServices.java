/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRec.services;

import ClienRec.entites.ClientRec;
import Clients.cnx.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;



/**
 *
 * @author Guide Info
 */
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
      
            String req ="INSERT INTO ClientRec(nom,prenom,tel,email,description,score) value (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(req);
           
            pst.setString(1,A.getNom());
            pst.setString(2,A.getPrenom());
            pst.setString(3,A.getTel());
            pst.setString(4,A.getEmail());
            pst.setString(5,A.getDescription());
            pst.setFloat(6,A.getScore());
            
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
     
     public ObservableList <ClientRec> getClientRec() {
          ObservableList<ClientRec> Clients = FXCollections.observableArrayList();
        try {
           
            String req =" Select* from ClientRec";
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(req);
           
            ResultSet rs = pst.executeQuery(req);
            ClientRec recc;
            while (rs.next())
            {
              recc  = new ClientRec ( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
              /*
              A.setId(rs.getInt("Id"));
              A.setNom(rs.getString("Nom"));
              A.setPrenom(rs.getString("Prenom"));
              A.setTel(rs.getString("Tel"));
              A.setEmail(rs.getString("Email"));
              A.setDescription(rs.getString("Description"));*/
              Clients.add(recc);
            }
            }     
catch (SQLException ex) {
          System.out.println(ex.getMessage()); 
        }
           return Clients;
     }

     
   public  void suppClients (int  id ){
  
        try {
           
         
            String rec = "DELETE FROM clientrec WHERE id= '"+id+"'" ;
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(rec);
          
            pst.executeUpdate();
       System.out.println("votre réclamation a été bien supprimée");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        
        }
   }
     
   
   
   
   
   public void ModiferClients( int id ,String nom , String prenom ,String tel , String email,String description,float score ) {
		try {
                  
                  
	 String rec="UPDATE ClientRec  SET nom='"+ nom + "',prenom='" + prenom +"',tel='" + tel+"',email='" +email+"',description='" +description+"' ,score='"+score+"' WHERE id="+id+"";

                  PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(rec);
	 
	    	
	     pst.executeUpdate();
             
                }
  	  catch (SQLException ex)
	  {
		 System.err.println(ex.getMessage());
	}
   }
    
           
    
   public   void ExisteClient( int id )
   {
       
 
           
            
        try {
            String res = "SELECT * FROM clientrec WHERE id= '"+id+"'" ;
            PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(res);
            
           
           ResultSet rs = pst.executeQuery(res);
           rs.last();
           int nbRow = rs.getRow();
           if (nbRow !=0)
           {
            System.out.println("le client est bien enregister dans notre base de données");
           }else
           {
               System.out.println("le client n'est pas enregister dans notre base de données");
           }
           
             pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println();
        }
         
        
       
   }
   
   
  public List<ClientRec> getMeilleurJoueur() throws SQLException{
          List<ClientRec> Joueur = new ArrayList<>();
       
       
         try {
             String res =" SELECT id,nom,prenom,MAX(score) FROM clientrec ";
             PreparedStatement pst = (PreparedStatement) cnxx.prepareStatement(res);
             ResultSet rs = pst.executeQuery(res);
             
            while (rs.next())
            {
              ClientRec B= new ClientRec(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(8)); 
               Joueur.add(B);
            }
            
         } catch (SQLException ex) {
             System.err.println(ex.getMessage());
         }
  return Joueur;
  }

    public void suppClients(TextField ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
  
  