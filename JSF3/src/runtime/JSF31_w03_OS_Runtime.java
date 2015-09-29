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
import timeutil.TimeStamp;

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
//--------Opdracht 5 en 7-------------------------------------------------------
//
//        TimeStamp ts = new TimeStamp();
//        ts.setBegin("Begin van de code");
//        Runtime r = Runtime.getRuntime();
//
//        try {
//            ts.setBegin("Begin van de ProcessBuilder");
//            ProcessBuilder pb = new ProcessBuilder();
//            pb.command("gnome-calculator");
//            Process p = pb.start();
//            ts.setEnd("Na aanmaken van de ProcessBuilder");
//            Thread.sleep(2000);
//            p.destroy();
//            ts.setBegin("Begin van de Calculator");
//            p = r.exec("gnome-calculator");
//            ts.setEnd("Na starten van de Calculator");
//            Thread.sleep(2000);
//            p.destroy();
//        } catch (IOException ioe) {
//            Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ioe);
//        } catch (InterruptedException ie) {
//            Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ie);
//        }
//
//        ts.setEnd("Einde van de code");
//        System.out.print(ts.toString());
//
//--------Opdracht 6------------------------------------------------------------
//
//        try {
//            ProcessBuilder pb = new ProcessBuilder();
//            pb.command("ls");
//            Process p = pb.start();
//            InputStream is = p.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            br.close();
//        } catch (IOException ioe) {
//            Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ioe);
//        }
//--------Opdracht 9-------------------------------------------------------
        if (args.length % 2 == 0 || args.length == 1) {
            TimeStamp ts = new TimeStamp();
            ts.setBegin("Begin van de code");
            Runtime r = Runtime.getRuntime();

            try {
                for (int i = 0; i < args.length; i += 2) {
                    ProcessBuilder pb = new ProcessBuilder();

                    if (args.length == 1 || args[i + 1].isEmpty()) {
                        pb.command(args[i]);
                    } else {
                        pb.command(args[i], args[i + 1]);
                    }

                    Process p = pb.start();
                    System.out.println(pb.command() + " started");
                    InputStream is = p.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line;

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                    br.close();
                    p.destroy();
                    System.out.println(pb.command() + " ended");
                }
            } catch (IOException ioe) {
                Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ioe);
            }

            ts.setEnd("Einde van de code");
            System.out.print(ts.toString());
        }
    }
}
