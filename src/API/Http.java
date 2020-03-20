/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author wills
 */
public class Http {

    public String getURL(String file) {
        String url = "http://localhost/API-TRANS/files/" + file + ".php";
        return url;
    }

    public JSONArray JSONdata(BufferedReader stream) {
        String line;
        String data = "";
        JSONArray JsonSONArray = null;
        if (stream != null) {
            try {
                while ((line = stream.readLine()) != null) {
                    data = data + line;
                }
                JsonSONArray = new JSONArray(data);
            } catch (IOException ex) {
                Logger.getLogger(Http.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JsonSONArray;
    }

}
