/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageUser;

import edu.esprit.entities.User;
import edu.esprit.services.UserService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mezri
 */
public class ManageUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("testtest", "testtest" , 12345678 , "test@gmail.com" , 25103207 , "12/01/1998" , "Ariana", "azerty" );
        userService.AddUser1(user);
        System.out.println(userService.getUsers());
        userService.update(23 , "test1" , "test1" , 12390613 , "test1@gmail.com" , 58021342 , "26/08/1998" , "ARIANA ESSOUGHRA" , "azerty");
        userService.delete(27);        
    }
    
}
