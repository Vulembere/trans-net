/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

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
public class Post extends Http {

    public BufferedReader save(String table,String code, String designation, String montant, String devise, String validite, String type) {
        BufferedReader in = null;
        String file = "save";
        try {
            URL url = new URL(getURL(file));
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.print("table=" + table);
            ps.print("&code=" + code);
            ps.print("&designation=" + designation);
            ps.print("&montant=" + montant);
            ps.print("&devise=" + devise);
            ps.print("&validite=" + validite);
            ps.print("&type=" + type);
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
    public BufferedReader delete(String table, String code) {
        BufferedReader in = null;
        String file = "delete";
        try {
            URL url = new URL(getURL(file));
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.print("table=" + table);
            ps.print("&code=" + code);
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            ps.close();
        } catch (MalformedURLException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return in;
    }

    public static Post post = new Post();
}
