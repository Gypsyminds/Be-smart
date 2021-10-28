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
    
   /* public void ajouterFacture (Facture f){
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
            pst.setInt(1,f.getClient().getId());
            pst.setString(2,f.getCat().getNomchap());
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
                Facture f = new Facture(rs.getInt(1), null, null, rs.getFloat(4));
               
                
                f.setClient(getClientById(rs.getInt(2)));
                f.setCat(getCategorieById(rs.getString(3)));
                
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
     public  void supprimerFacture1 (int id ){
  
        try {
            String req = "DELETE FROM facture WHERE id= '"+id+"'" ;
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
           
            pst.executeUpdate();
         
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        }
   }   
     public  void modifierFacture1 (int id ,int clientId,String categoieId,float montanttot){
  
        try {
            String req = "UPDATE `facture`SET client="+clientId+",cat='"+categoieId+"',montanttot="+montanttot+" WHERE id=" + id ;
              PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
               pst.executeUpdate();
         
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
           
        }
   } 

    public Client getClientById(int id) {
    try {
            String req = "SELECT * FROM `client` WHERE `id` = "+id;
//            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
//            pst.setInt(1,id);
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Client client = new Client(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
          return client;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;    
    }
    public Categorie getCategorieById(String nomchap) {
    try {
            String req = "SELECT * FROM `categorie` WHERE `nomchap` = '"+nomchap+"'";
//            String req = "SELECT * FROM `categorie` WHERE `nomchap` = 'tunis';";
//            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
//            pst.setString(tunis,nomchap);
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Categorie cat = new Categorie(rs.getString(1), rs.getString(2), rs.getFloat(3));
          return cat;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
}
}