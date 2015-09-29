/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsf3
 */
public class JSF31_w03_OS_Runtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//--------Opdracht 3 en 4-------------------------------------------------------
//      
//        Runtime r = Runtime.getRuntime();
//        System.out.println("3a. Beschikbare processoren: " + r.availableProcessors());
//        System.out.println("3b. Totaal geheugen: " + r.totalMemory());
//        System.out.println("3c. Max geheugen: " + r.maxMemory());
//        System.out.println("3d. Vrij geheugen: " + r.freeMemory());
//        System.out.println("3e. Gebruikte geheugen: " + (r.totalMemory() - r.freeMemory()));
//        
//        String s;
//        
//        for (int i = 0; i < 100000; i++) {
//            s = "Hello" + i;
//        }
//        
//        System.out.println("4. Gebruikte geheugen na de for loop: " + (r.totalMemory() - r.freeMemory()));
//        System.gc();
//        System.out.println("4. Gebruikte geheugen na de Garbage Collector: " + (r.totalMemory() - r.freeMemory()));
//
//--------Opdracht 5------------------------------------------------------------
//
//        Runtime r = Runtime.getRuntime();
//        
//        try {
//            ProcessBuilder pb = new ProcessBuilder();
//            pb.command("gnome-calculator");
//            Process p = pb.start();
//            Thread.sleep(2000);
//            p.destroy();
//            p = r.exec("gnome-calculator");
//            Thread.sleep(2000);
//            p.destroy();
//        } catch (IOException ioe) {
//            Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ioe);
//        } catch (InterruptedException ie) {
//            Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ie);
//        }
//
//--------Opdracht 6------------------------------------------------------------
//
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("ls");
            Process p = pb.start();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException ioe) {
            Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
}
