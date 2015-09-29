/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import calculate.*;
import java.util.*;

/**
 *
 * @author Joris
 */
public class JSF31KochFractalConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EdgeObserver eo = new EdgeObserver();
        KochFractal kf = new KochFractal();
        kf.addObserver(eo);
        kf.setLevel(2);
        kf.generateBottomEdge();
        kf.generateLeftEdge();
        kf.generateRightEdge();
    }
}

class EdgeObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Edge e = (Edge) arg;
        System.out.println("Edge from (" + e.X1 + ", " + e.Y1 + ") to (" + e.X2 + ", " + e.Y2 + ")");
    }
}
