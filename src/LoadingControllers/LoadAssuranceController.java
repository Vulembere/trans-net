/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadingControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author wills
 */
public class LoadAssuranceController implements Initializable {

    @FXML
    private Label txtMontant;
    @FXML
    private Label txtDevise;
    @FXML
    private Label txtDesignation;
    @FXML
    private Label txtNumero;
    public static String Montnat;
    public static String devise;
    public static String Numero;
    public static String Designation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDesignation.setText(Designation);
        txtDevise.setText(devise);
        txtMontant.setText(Montnat);
        txtNumero.setText(Numero);
    }

}
