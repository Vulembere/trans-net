/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import cls.var;
import static cls.var.v;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author wills
 */
public class Get extends Http {

    public BufferedReader loadData(String table) {
        BufferedReader in = null;
        String file = "load";
        try {
            URL url = new URL(getURL(file));
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.print("&table=" + table);
            con.getInputStream();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            ps.close();
        } catch (MalformedURLException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return in;
    }
    public static Get get = new Get();
}
