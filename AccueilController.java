/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRec.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Guide Info
 */
public class AccueilController implements Initializable {

      
    @FXML
    private Button AJOUTER;
    @FXML
    private Button SUPPRIMER;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ajouterr ();
      SUPP();
    }
       private void ajouterr (){
           
   
    AJOUTER.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamations.fxml"));
                Parent root = loader.load();
                
                ReclamationsController conn = loader.getController();
                
                
                
                
                AJOUTER.getScene().setRoot(root);
            } catch (IOException ex) {
               System.err.println(ex.getMessage());
            }
           
        }
    });
    
}
       
       
  private void SUPP(){
           
   
    SUPPRIMER.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenuDeReclamations.fxml"));
                Parent root = loader.load();
                
               ContenuDeReclamationsController conn = loader.getController();
                
                
                
                
                SUPPRIMER.getScene().setRoot(root);
            } catch (IOException ex) {
               System.err.println(ex.getMessage());
            }
           
        }
    });
    
}      
}
