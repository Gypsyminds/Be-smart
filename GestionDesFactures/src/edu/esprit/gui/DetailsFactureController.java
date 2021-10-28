/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import gestiondesfactures.entite.Facture;
import gestiondesfactures.entite.FactureDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import service.ServiceFacture;

/**
 * FXML Controller class
 *
 * @author ZNJ
 */
public class DetailsFactureController implements Initializable {

    @FXML
    private TableView<FactureDto> table;
    @FXML
    private Button btSUPPRIMER;
//    
    ServiceFacture sf = new ServiceFacture();
    ObservableList<FactureDto> factureDtos = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setEditable(true);

        TableColumn<FactureDto, Integer> idColumn = new TableColumn<FactureDto, Integer>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<FactureDto, Integer>("Id"));

        TableColumn<FactureDto, Integer> idClientColumn = new TableColumn<FactureDto, Integer>("Id Client");
        idClientColumn.setCellValueFactory(new PropertyValueFactory<FactureDto, Integer>("idClient"));
        idClientColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        idClientColumn.setOnEditCommit(new EventHandler<CellEditEvent<FactureDto, Integer>>() {
            @Override
            public void handle(CellEditEvent<FactureDto, Integer> event) {
                FactureDto factureDto = event.getRowValue();
                factureDto.setIdClient(event.getNewValue());
                sf.modifierFacture1(factureDto.getId(), factureDto.getIdClient(), factureDto.getCat(), factureDto.getMontant());
                factureDtos.setAll(sf.getFactures().stream().map(e -> mapFactureToFactureDto(e)).collect(Collectors.toList()));
                table.setItems(factureDtos);
            }
        });
        TableColumn<FactureDto, String> firstNameColumn = new TableColumn<FactureDto, String>("Prenom");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<FactureDto, String>("Prenom"));

        TableColumn<FactureDto, String> lastNameColumn = new TableColumn<FactureDto, String>("Nom");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<FactureDto, String>("Nom"));

        TableColumn<FactureDto, String> catColumn = new TableColumn<FactureDto, String>("Cat");
        catColumn.setCellValueFactory(new PropertyValueFactory<FactureDto, String>("Cat"));
        catColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        catColumn.setOnEditCommit(new EventHandler<CellEditEvent<FactureDto, String>>() {
            @Override
            public void handle(CellEditEvent<FactureDto, String> event) {
                FactureDto factureDto = event.getRowValue();
                factureDto.setCat(event.getNewValue());
                sf.modifierFacture1(factureDto.getId(), factureDto.getIdClient(), factureDto.getCat(), factureDto.getMontant());
                factureDtos.setAll(sf.getFactures().stream().map(e -> mapFactureToFactureDto(e)).collect(Collectors.toList()));
                table.setItems(factureDtos);
            }
        });

        TableColumn<FactureDto, Float> montantColumn = new TableColumn<FactureDto, Float>("Montant");
        montantColumn.setCellValueFactory(new PropertyValueFactory<FactureDto, Float>("Montant"));
        montantColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        montantColumn.setOnEditCommit(new EventHandler<CellEditEvent<FactureDto, Float>>() {
            @Override
            public void handle(CellEditEvent<FactureDto, Float> event) {
                FactureDto factureDto = event.getRowValue();
                factureDto.setMontant(event.getNewValue());
                sf.modifierFacture1(factureDto.getId(), factureDto.getIdClient(), factureDto.getCat(), factureDto.getMontant());
                factureDtos.setAll(sf.getFactures().stream().map(e -> mapFactureToFactureDto(e)).collect(Collectors.toList()));
                table.setItems(factureDtos);
            }
        });

        table.getColumns().add(idColumn);
        table.getColumns().add(idClientColumn);
        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(catColumn);
        table.getColumns().add(montantColumn);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        factureDtos.setAll(sf.getFactures().stream().map(e -> mapFactureToFactureDto(e)).collect(Collectors.toList()));
        table.setItems(factureDtos);

    }

    private FactureDto mapFactureToFactureDto(Facture e) {
        FactureDto factureDto = new FactureDto();
        factureDto.setId(e.getId());
        factureDto.setIdClient(e.getClient().getId());
        factureDto.setNom(e.getClient().getNom());
        factureDto.setPrenom(e.getClient().getPrenom());
        factureDto.setCat(e.getCat().getNomchap());
        factureDto.setMontant(e.getMontanttot());
        return factureDto;

//To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void suFc(ActionEvent event) {
        ObservableList<FactureDto> singleFacture = table.getSelectionModel().getSelectedItems();
        System.err.print(singleFacture);
//        SingleFacture.forEach(allFacture::remove);
        sf.supprimerFacture1(singleFacture.get(0).getId());
        factureDtos.setAll(sf.getFactures().stream().map(e -> mapFactureToFactureDto(e)).collect(Collectors.toList()));
        table.setItems(factureDtos);
    }

//    @FXML
//    private void onEditChange(TableColumn.CellEditEvent<FactureDto, String> event) {
//        FactureDto factureDto = table.getSelectionModel().getSelectedItem();
//        factureDto.setMontant(Float.parseFloat(event.getNewValue()));
//    }
}
