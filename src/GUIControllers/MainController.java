/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import cls.evenements;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author wills
 */
public class MainController implements Initializable {

    @FXML
    private Label btn_CallNouveau;
    @FXML
    private StackPane mainStack;
    public static StackPane MainStock;
    @FXML
    private StackPane contenaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void Call_nouveau(MouseEvent event) throws IOException {
        evenements.ev.setForm(contenaire, "/Interface/Nouveau.fxml");
    }

}
