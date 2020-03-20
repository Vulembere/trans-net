/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceControllers;

import cls.evenements;
import cls.var;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import panelsControllers.AssurencesController;

/**
 * FXML Controller class
 *
 * @author wills
 */
public class NouveauController implements Initializable {
    
    @FXML
    private Label btn_CallNouveau;
    @FXML
    private JFXButton btn_callassurence;
    @FXML
    private StackPane contrnaire;
    @FXML
    private JFXButton btn_callDocuments;
    @FXML
    private JFXButton btn_callFaute;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void Call_nouveau(MouseEvent event) throws IOException {
        var.setDetaille("Assurance");
        evenements.ev.SelectDataFor(btn_callassurence,btn_callDocuments,btn_callFaute);
        evenements.ev.setForm(contrnaire, "/panels/Assurences.fxml");
    }
    
    @FXML
    private void CallDocunent(MouseEvent event) throws IOException {
        var.setDetaille("Document");
        evenements.ev.SelectDataFor(btn_callDocuments,btn_callFaute,btn_callassurence);
        evenements.ev.setForm(contrnaire, "/panels/Assurences.fxml");
    }
    
    @FXML
    private void caulFaute(MouseEvent event) throws IOException {
        var.setDetaille("Faute");
         evenements.ev.SelectDataFor(btn_callFaute,btn_callDocuments,btn_callassurence);
        evenements.ev.setForm(contrnaire, "/panels/Assurences.fxml");
    }
    
}
