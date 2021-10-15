/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import gestiondesfactures.entite.Categorie;
import gestiondesfactures.entite.Client;
import gestiondesfactures.entite.Facture;
import gestiondesfactures.utis.MyConnection;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZNJ
 */
public class ServiceFacture {
     private Connection cnx;

    public ServiceFacture() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterFacture (Facture f){
        try {
            String req = "INSERT INTO gestiondesfactures  (client,cat,montanttot) values ('"+f.getClient()+"','"+f.getCat()+"','"+f.getMontanttot()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Facture added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param f
     */
    public void ajouterFacture1(Facture f){
        try {
            String req = "INSERT INTO facture (client,cat,montanttot) values (?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setArray(1, (Array) f.getClient());
            pst.setArray(2, (Array) f.getCat());
            pst.setFloat(3, f.getMontanttot());
            pst.executeUpdate();
            System.out.println("facture added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Facture> getFactures(){
        List<Facture> factures = new ArrayList<>();
        try {
            String req = "Select * from facture";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Facture f = new Facture(rs.getString(1), (Client)rs.getObject(2), (Categorie)rs.getObject(3), rs.getFloat(4));
                factures.add(f);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return factures;
    }
       public float calcul( Categorie[] c){
       float s=0;
    for( int i=0;i<=c.length;i++)
         {s=c[i].getPrixcat()+s;
     
       }
       return s;
       
       }
     public  void supprimerFacture1 (String id ){
  
        try {
            String req = "DELETE FROM facture WHERE id= '"+id+"'" ;
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
           
            pst.executeUpdate();
         
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        }
   }   
     public  void modifierFacture1 (String id ,String clientId,String categoryId){
  
        try {
            String req = "UPDATE `facture`SET client='"+clientId+"',categorie='"+categoryId+"',WHERE id='" + id + "'";
              PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
               pst.executeUpdate();
         
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        }
   } 
}
