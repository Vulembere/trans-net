/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelsControllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author wills
 */
public class AssurencesController implements Initializable {

    @FXML
    private TextField txtCustomer;
    @FXML
    private JFXButton btcustomer;
    @FXML
    private TextField txtCustomer1;
    @FXML
    private VBox vb;
    @FXML
    private Text title;
    @FXML
    private Text title1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addcustomer(ActionEvent event) {
    }
    
}
