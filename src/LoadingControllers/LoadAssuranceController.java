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
import javafx.scene.input.MouseEvent;
import panelsControllers.AssurencesController;

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
    public static String Validite;
    public static String Type;
    public static String Code;
    @FXML
    private Label txtValidite;
    @FXML
    private Label txtType;
    @FXML
    private Label txtCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDesignation.setText(Designation);
        txtDevise.setText(devise);
        txtMontant.setText(Montnat);
        txtNumero.setText(Numero);
        txtValidite.setText(Validite);
        txtType.setText(Type);
        txtCode.setText(Code);
    }

    @FXML
    private void onclickData(MouseEvent event) {
        AssurencesController.newButon.setVisible(true);
        AssurencesController.newCode.setText(txtCode.getText());
        AssurencesController.newDesignation.setText(txtDesignation.getText());
        AssurencesController.newMontant.setText(txtMontant.getText());
        AssurencesController.newType.getSelectionModel().select(txtType.getText());
        AssurencesController.newDevise.getSelectionModel().select(txtDevise.getText());
        AssurencesController.newValidite.setText(txtValidite.getText());
    }

}
