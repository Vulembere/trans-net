/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cls;

import java.lang.reflect.Field;
import javafx.scene.control.ComboBox;

/**
 *
 * @author wills
 */
public class var {
    public static String Detaille;

    public static String getDetaille() {
        return Detaille;
    }

    public static void setDetaille(String Detaille) {
        var.Detaille = Detaille;
    }
    public static void loadDevise(ComboBox<String> box) {
        box.getItems().add("USD");
        box.getItems().add("FC");
    }

    public static void loadValidite(ComboBox<String> box) {
        box.getItems().add("Heur");
        box.getItems().add("Jour");
        box.getItems().add("Mois");
        box.getItems().add("Année");
    }

    public String getVarName(Object classe, Object o) throws java.lang.IllegalAccessException {
        Field[] f = classe.getClass().getFields();
        for (Field f1 : f) {
            if (o.equals(f1.get(classe))) {
                return f1.getName();
            }
        }
        return "";
    }
    public static var v = new var();
}
