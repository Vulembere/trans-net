/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelsControllers;

import API.Get;
import static API.Get.get;
import API.Post;
import static API.Post.post;
import cls.evenements;
import static cls.evenements.ev;
import cls.var;
import com.jfoenix.controls.JFXButton;
import static data.DATA.d;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private JFXButton btcustomer;
    @FXML
    private VBox vb;
    @FXML
    private TextField txtDesignation;
    @FXML
    private TextField txtMontant;
    @FXML
    private ComboBox<String> txtDevise;
    @FXML
    private TextField txtValidite;
    @FXML
    private ComboBox<String> txtType;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private FontAwesomeIconView font;
    @FXML
    private Label labInfos;
    @FXML
    private Label txtCode;
    public static TextField newDesignation;
    public static ComboBox newType;
    public static TextField newMontant;
    public static ComboBox newDevise;
    public static Label newCode;
    public static TextField newValidite;
    public static JFXButton newButon;
    public static Text newDetaill;
    @FXML
    private Text txtDetail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newDetaill = txtDetail;
        newDesignation = txtDesignation;
        newType = txtType;
        newMontant = txtMontant;
        newDevise = txtDevise;
        newButon = btnDelete;
        newValidite = txtValidite;
        newCode = txtCode;
        newDetaill = txtDetail;

        var.loadDevise(txtDevise);
        var.loadValidite(txtType);
        btnDelete.setVisible(false);
        txtDetail.setText(var.getDetaille());
        switch (txtDetail.getText()) {
            case "Assurance":
                d.loadList(vb, post.JSONdata(get.loadData("assurence")));
                break;
            case "Document":
                d.loadList(vb, post.JSONdata(get.loadData("documents")));
                break;
            case "Faute":
                d.loadList(vb, post.JSONdata(get.loadData("fautes")));
                break;
        }
    }

    @FXML
    private void addcustomer(ActionEvent event) {
        if (evenements.isFieldsempty(txtDesignation, txtDevise, txtMontant, txtType, txtValidite)) {
            ev.showMssge(labInfos, font, "Aucune case ne doit etre vide !", 0);
        } else {
            BufferedReader read = null;
            switch (txtDetail.getText()) {
                case "Assurance":
                    read = post.save("assurence", txtCode.getText(), txtDesignation.getText(), txtMontant.getText(), txtDevise.getValue(), txtValidite.getText(), txtType.getValue());
                    break;
                case "Document":
                    read = post.save("Document", txtCode.getText(), txtDesignation.getText(), txtMontant.getText(), txtDevise.getValue(), txtValidite.getText(), txtType.getValue());
                    break;
                case "Faute":
                    read = post.save("faute", txtCode.getText(), txtDesignation.getText(), txtMontant.getText(), txtDevise.getValue(), txtValidite.getText(), txtType.getValue());
                    break;
            }
            if (read != null) {
                ev.showMssge(labInfos, font, "Enregistrement effetué avec Succè !", 1);
                d.loadList(vb, post.JSONdata(read));
                txtCode.setText("0");
                btnDelete.setVisible(false);
                evenements.initFields(txtDesignation, txtDevise, txtMontant, txtType, txtValidite);
            } else {
                ev.showMssge(labInfos, font, "Echec d'enregistrement", 0);
            }
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        if (!txtCode.getText().equals("0")) {
            BufferedReader read = null;
            switch (txtDetail.getText()) {
                case "Assurance":
                    read = post.delete("assurence", txtCode.getText());
                    break;
                case "Document":
                    read = post.delete("documents", txtCode.getText());
                    break;
                case "Faute":
                    read = post.delete("faute", txtCode.getText());
                    break;
            }
            if (read != null) {
                ev.showMssge(labInfos, font, "suppression effetué avec Succè !", 1);
                evenements.initFields(txtDesignation, txtDevise, txtMontant, txtType, txtValidite);
                d.loadList(vb, post.JSONdata(read));
                txtCode.setText("0");
                btnDelete.setVisible(false);
            } else {
                ev.showMssge(labInfos, font, "Echec de suppression !", 0);
            }
        } else {
            ev.showMssge(labInfos, font, "Vous devez sélectionner un element SVP", 0);
        }
    }

}
