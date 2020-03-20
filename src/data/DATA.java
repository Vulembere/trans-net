/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import LoadingControllers.LoadAssuranceController;
import static cls.evenements.ev;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author wills
 */
public class DATA {
    
    public ArrayList<String> ASSURANCE = new ArrayList();
    public ArrayList<Float> VALEUR = new ArrayList();
    public ArrayList<String> DEVISE = new ArrayList();
    public ArrayList<Integer> VALIDITE = new ArrayList();
    public ArrayList<String> TYPE = new ArrayList();
    public ArrayList<Integer> CODE = new ArrayList();
    
    public void loadList(VBox box, JSONArray jsonArray) {
        int x = 0;
        init();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject ob = jsonArray.getJSONObject(i);
                VALEUR.add(ob.getFloat("valeur"));
                ASSURANCE.add(ob.getString("designation"));
                DEVISE.add(ob.getString("devise"));
                VALIDITE.add(ob.getInt("validite"));
                TYPE.add(ob.getString("type_"));
                CODE.add(ob.getInt("code"));
            }
        }
        box.getChildren().clear();
        AnchorPane[] node = new AnchorPane[VALEUR.size()];
        while (x < VALEUR.size()) {
            try {
                LoadAssuranceController.Designation = ASSURANCE.get(x);
                LoadAssuranceController.Montnat = String.valueOf(VALEUR.get(x));
                LoadAssuranceController.devise = DEVISE.get(x);
                LoadAssuranceController.Code = String.valueOf(CODE.get(x));
                LoadAssuranceController.Numero = String.valueOf(x + 1);
                LoadAssuranceController.Validite = String.valueOf(VALIDITE.get(x));
                LoadAssuranceController.Type = String.valueOf(TYPE.get(x));
                node[x] = FXMLLoader.load(getClass().getResource("/Loading/loadAssurance.fxml"));
                box.getChildren().add(node[x]);
                x++;
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            
        }
    }
    
    void init() {
        CODE.clear();
        ASSURANCE.clear();
        VALIDITE.clear();
        DEVISE.clear();
        VALEUR.clear();
        TYPE.clear();
    }
    public static DATA d = new DATA();
}
