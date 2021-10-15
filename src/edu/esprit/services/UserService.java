/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import edu.esprit.entities.User;
import edu.esprit.utils.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.sql.PreparedStatement;




/**
 *
 * @author Adem
 */
public class UserService {
    
    private Connection cnx;
    Statement st;
    PreparedStatement pst = null;
    public UserService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void AddUser (User user){
        try {
            String req = "INSERT INTO user (nom,prenom,cin,email,numeroTel,dob,adresse,password) values ('"+user.getNom()+"','"+user.getPrenom()+"','"+user.getCin()+"','"+user.getEmail()+"','"+user.getNumeroTel()+"','"+user.getDob()+"','"+user.getAdresse()+"','"+user.getPassword()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void AddUser1(User user){
        try {
            String req = "INSERT INTO user (nom,prenom,cin,email,numeroTel,dob,adresse,password) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setInt(3, user.getCin());
            pst.setString(4, user.getEmail());
            pst.setInt(5, user.getNumeroTel());
            pst.setString(6, user.getDob());
            pst.setString(7, user.getAdresse());
            pst.setString(8, user.getPassword());
            pst.executeUpdate();
            System.out.println("Personne added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        try {
            String req = "Select * from user";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                User user = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9));
                users.add(user);
                
                    
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(users);
    return users;
    }
    
    //update the db
    public void update(int ID ,String NOM , String PRENOM , int CIN , String EMAIL , int NUMEROTEL , String DOB , String ADRESSE , String PASSWORD) {
          
        try {
            
            //Class.forName("com.mysql.jdbc.Driver");
            //cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "");
            String sql = "UPDATE user SET nom='" + NOM + "',prenom='" + PRENOM+"' , cin='" + CIN + "', email='" + EMAIL + "' , numeroTel='" + NUMEROTEL + "' , dob='" + DOB + "' , adresse='" + ADRESSE + "',password='" + PASSWORD + "' WHERE id='" + ID + "'";
            //String sql = "UPDATE user SET nom=? , prenom=? , cin=? , email=? , numeroTel=? , dob=? , adresse=? , password=?  where id=? " ;
            //st = cnx.createStatement();
            //pst = cnx.prepareStatement(sql);
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(sql);
            
            
           /* pst.setString(1, NOM);
            pst.setString(2, PRENOM);
            pst.setInt(3,CIN);
            pst.setString(4, EMAIL);
            pst.setInt(5, NUMEROTEL);
            pst.setString(6 ,DOB);
            pst.setString(7 ,ADRESSE);
            pst.setString(8 ,PASSWORD);
            pst.setInt(9 ,ID);*/
            
          
            pst.executeUpdate();
            pst.execute(sql);
            
            System.out.println("DATA UPDATED !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
//        fetch();
    }
    
    //delete details in the db
    public void delete(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "");
            String sql = "DELETE FROM `user` WHERE id='" + id + "'";
            st = cnx.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
           System.out.println("Oups personne deleted !");
    }
}
