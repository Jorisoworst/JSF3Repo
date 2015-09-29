/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.*;
import java.util.logging.*;
import timeutil.TimeStamp;

/**
 *
 * @author jsf3
 */
class MyRunnable implements Runnable {

    private String command;
    private String argument;

    public MyRunnable(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }

    @Override
    public void run() {
        if (!this.command.isEmpty()) {
            TimeStamp ts = new TimeStamp();
            ts.setBegin("Begin van de code");
            Runtime r = Runtime.getRuntime();

            try {
                ProcessBuilder pb = new ProcessBuilder();

                if (!this.argument.isEmpty()) {
                    pb.command(this.command, this.argument);
                } else {
                    pb.command(this.command);
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
            } catch (IOException ioe) {
                Logger.getLogger(JSF31_w03_OS_Runtime.class.getName()).log(Level.SEVERE, null, ioe);
            }

            ts.setEnd("Einde van de code");
            System.out.print(ts.toString());
        }
    }
}
