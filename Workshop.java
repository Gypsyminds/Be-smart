/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

import edu.esprit.entities.User;
import edu.esprit.services.UserService;


/**
 *
 * @author mezri
 */
public class Workshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("Adem", "Zeiri" , 12345678 , "ademzeiri@gmail.com" , 25103207 , "12/01/1998" , "Ariana" );
        //user.AddUsers(user);
        System.out.println(userService.getUsers());
    }
    
}
