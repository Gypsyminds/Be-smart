/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientRec.gui;



import ClienRec.entites.ClientRec;
import ClientRec.services.RecServices;
import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;



import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;



import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author Guide Info
 */
public class ContenuDeReclamationsController implements Initializable {
    
    
    @FXML
    private TableColumn<ClientRec, Integer> Id;
    @FXML
    private TableColumn<ClientRec, String> Nom;
    @FXML
    private TableColumn<ClientRec, String> Prénom;
    @FXML
    private TableColumn<ClientRec, String> Tel;
    @FXML
    private TableColumn<ClientRec, String> Email;
    @FXML
    private TableColumn<ClientRec, String> Description;
    @FXML
    private TableView<ClientRec> tfTable;
    @FXML
    private Button RETOUR;
    @FXML
    private Button tfSUPP;
   

 
    /**
     *
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   AllReclamation();
retour();

    }
      private void AllReclamation(){
          
        
       
          ObservableList<ClientRec> Clients = FXCollections.observableArrayList();
          RecServices rec = new RecServices();
          Clients = rec.getClientRec();
          
          Id.setCellValueFactory(new PropertyValueFactory<>("id"));
          Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Prénom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
          Tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
          Email.setCellValueFactory(new PropertyValueFactory<>("email"));
          Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
          tfTable.setItems(Clients);
       
      }
private void retour (){
        
   
    RETOUR.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
                Parent root = loader.load();
                
                AccueilController conn = loader.getController();
                
                
                
                
                RETOUR.getScene().setRoot(root);
            } catch (IOException ex) {
               System.err.println(ex.getMessage());
            }
           
        }
    });
}

    @FXML
    private void delete(ActionEvent event) {
        ObservableList<ClientRec> Clients = tfTable.getSelectionModel().getSelectedItems();
        RecServices rec = new RecServices();
        rec.suppClients(Clients.get(0).getId());
        
        
    }
    
    
    
    
    
    private static class timestamp {

        public timestamp() {
        }
    }

   

   
      
       
  
   
   

    
        

            
            
       
    
        }  
    


   