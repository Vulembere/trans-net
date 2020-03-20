/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelsControllers;

import static API.Get.get;
import static API.Post.post;
import com.jfoenix.controls.JFXButton;
import static data.DATA.d;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author wills
 */
public class DocumentsController implements Initializable {

    @FXML
    private TextField txtDesignation;
    @FXML
    private JFXButton btcustomer;
    @FXML
    private TextField txtMontant;
    @FXML
    private ComboBox<?> txtDevise;
    @FXML
    private VBox vb;
    @FXML
    private TextField txtValidite;
    @FXML
    private ComboBox<?> txtType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          d.loadList(vb, post.JSONdata(get.loadData("documents")));
    }

    @FXML
    private void addcustomer(ActionEvent event) {
    }

}
