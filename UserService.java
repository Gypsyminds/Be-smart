/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
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




/**
 *
 * @author Adem
 */
public class UserService {
    
    private Connection cnx;
    Statement st;
    public UserService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void AddUser (User user){
        try {
            String req = "INSERT INTO personne (nom,prenom,cin,email,numeroTel,dob,adresse) values ('"+user.getNom()+"','"+user.getPrenom()+"','"+user.getCin()+"','"+user.getEmail()+"','"+user.getNumeroTel()+"','"+user.getDob()+"','"+user.getAdresse()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void AddUser1(User user){
        try {
            String req = "INSERT INTO user (nom,prenom,cin,email,numeroTel,dob,adresse) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setInt(3, user.getCin());
            pst.setString(4, user.getEmail());
            pst.setInt(5, user.getNumeroTel());
            pst.setString(6, user.getDob());
            pst.setString(7, user.getAdresse());
            pst.executeUpdate();
            System.out.println("Personne added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try {
            String req = "Select * from user";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                User user = new User(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
                users.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return users;
    }
    
    //update the db
    public void update(int id , String nom, String prenom , int cin , String email , int numeroTel , String dob , String adresse) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "");
            String sql = "UPDATE `user`SET nom='" + nom + "',prenom='" + prenom+"' , cin='" + cin + "', email='" + email + "' , numeroTel='" + numeroTel + "' , dob='" + dob + "' , adresse='" + adresse + "' ,WHERE id='" + id + "'";
            st = cnx.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
