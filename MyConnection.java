/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package réc.parent.cnx;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Guide Info
 */
public class MyConnection {
    private String url="jdbc:mysql://localhost:3306/réclamation";
    private String user ="root";
    private String pwd ="";
    private Connection cnxx;
    
    private static  MyConnection mycnx;

    private MyConnection() {
        try {
            cnxx =(Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("connected!");
            
            } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
                                }
                            }
    
            
            
 public Connection getConnection() {
               return cnxx;
           }
public static MyConnection getMycnx(){
 if (mycnx == null){
     mycnx = new MyConnection ();
     return mycnx;     
} 
 return mycnx;
}
}

