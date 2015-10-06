/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Joris
 */
public class MyRunnable implements Runnable, Observer {

    private final KochManager km;
    private final KochFractal kf;
    private final String type;

    @SuppressWarnings("LeakingThisInConstructor")
    public MyRunnable(KochManager km, KochFractal kf, String type) {
        this.km = km;
        this.kf = kf;
        this.type = type;
        this.kf.addObserver(this);
    }

    @Override
    public void run() {
        switch (this.type) {
            case "L": {
                this.kf.generateLeftEdge();
                break;
            }
            case "B": {
                this.kf.generateBottomEdge();
                break;
            }
            case "R": {
                this.kf.generateRightEdge();
                break;
            }
            default: {
                break;
            }
        }

        this.km.incrementCount();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.km.addEdge((Edge) arg);
    }
}
