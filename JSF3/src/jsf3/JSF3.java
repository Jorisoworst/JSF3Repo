/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf3;

import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Joris
 */
public class JSF3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//------------------------------------------------------------------------------        
//        Properties props = new Properties();
//        String key = "";
//        String value = "";
//
//        for (String s : System.getenv().keySet()) {
//            if (s.equals("TestEnviron")) {
//                key = s;
//                value = System.getenv(key);
//            }
//        }
//        
//        System.out.println(key + "=" + value);
//        
//        props.put(key, value);
//
//        try {
//            FileOutputStream out = new FileOutputStream("/home/jsf3/NetBeansProjects/JSF3Repo/appProperties");
//            props.store(out, "NoComment");
//            out.close();
//        } catch (FileNotFoundException fnfe) {
//            Logger.getLogger(JSF3.class.getName()).log(Level.SEVERE, null, fnfe);
//        } catch (IOException ioe) {
//            Logger.getLogger(JSF3.class.getName()).log(Level.SEVERE, null, ioe);
//        }
//        
//------------------------------------------------------------------------------   
//        
//        Properties props = new Properties();
//        
//        try {
//            FileInputStream in = new FileInputStream("/home/jsf3/NetBeansProjects/JSF3Repo/appProperties");
//            props.load(in);
//            in.close();
//        } catch (FileNotFoundException fnfe) {
//            Logger.getLogger(JSF3.class.getName()).log(Level.SEVERE, null, fnfe);
//        } catch (IOException ioe) {
//            Logger.getLogger(JSF3.class.getName()).log(Level.SEVERE, null, ioe);
//        }
//
//        for (Object key : props.keySet().toArray()) {
//            System.out.println(key + "=" + props.getProperty(key.toString()));
//        }
//        
//------------------------------------------------------------------------------   
//
        if (args.length % 2 == 0) {
            Properties props = new Properties();

            for (int i = 0; i < args.length; i += 2)
            {
                props.put(args[i], args[i + 1]);
            }

            try {
                FileInputStream in = new FileInputStream("/home/jsf3/NetBeansProjects/JSF3Repo/appProperties");
                props.load(in);
                in.close();
            } catch (FileNotFoundException fnfe) {
                Logger.getLogger(JSF3.class.getName()).log(Level.SEVERE, null, fnfe);
            } catch (IOException ioe) {
                Logger.getLogger(JSF3.class.getName()).log(Level.SEVERE, null, ioe);
            }

            for (Object key : props.keySet().toArray()) {
                System.out.println(key + "=" + props.getProperty(key.toString()));
            }
        } else {
            System.out.println("Vul de argumenten in dit format in : <propN> <valN>.");
        }
    }
}
