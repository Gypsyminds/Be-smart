/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRec.gui;

import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;


 
public class AjoterReclamation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
   
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
            /*Parent  root = FXMLLoader.load(getClass().getResource("Reclamations.fxml"));*/
            Scene scene = new Scene(root);
          
            primaryStage.setTitle("Espace Réclamations");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
         catch (IOException ex) {
           System.err.println(ex.getMessage());
        }
    }

    
   
     
    public static void main(String[] args) {
        launch(args);
        
    }
    
}

    
    
