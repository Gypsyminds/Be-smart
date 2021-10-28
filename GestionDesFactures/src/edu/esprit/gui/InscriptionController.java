/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import gestiondesfactures.entite.Facture;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.ServiceFacture;

/**
 * FXML Controller class
 *
 * @author ZNJ
 */
public class InscriptionController implements Initializable {

    
    @FXML
    private TextField tfclient;
    @FXML
    private TextField tfcat;
    @FXML
    private TextField tfmontanttot;
    @FXML
    private Button btnvalider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveFacture(ActionEvent event) {
        
        int client = Integer.parseInt (tfclient.getText());
        String cat = tfcat.getText();
        float montanttot = Float.parseFloat(tfmontanttot.getText());
        ServiceFacture sv = new ServiceFacture();
        Facture f = new Facture(sv.getClientById(client), sv.getCategorieById(cat), montanttot);
        ServiceFacture sf = new ServiceFacture();
        sf.ajouterFacture1(f);
    }
    
}
