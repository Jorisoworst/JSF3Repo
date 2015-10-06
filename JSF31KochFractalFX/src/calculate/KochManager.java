/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.*;
import jsf31kochfractalfx.JSF31KochFractalFX;
import timeutil.TimeStamp;

/**
 *
 * @author Joris
 */
public class KochManager /*implements Observer*/ {

    private final JSF31KochFractalFX application;
    private final KochFractal koch;
    private final ArrayList<Edge> edges;
    private TimeStamp generationTime;
    private Thread leftThread, bottomThread, rightThread;
    private final MyRunnable leftRunnable, bottomRunnable, rightRunnable;
    private int count;

    public KochManager(JSF31KochFractalFX application) {
        this.application = application;
        this.koch = new KochFractal();
//        this.koch.addObserver(this);
        this.edges = new ArrayList<>();
        this.count = 0;
        this.leftRunnable = new MyRunnable(this, this.koch, "L");
        this.bottomRunnable = new MyRunnable(this, this.koch, "B");
        this.rightRunnable = new MyRunnable(this, this.koch, "R");
    }

    public void changeLevel(int nxt) {
        this.koch.setLevel(nxt);
        this.edges.clear();

        this.generationTime = new TimeStamp();

        this.generationTime.setBegin("Generation Start");

        this.leftThread = new Thread(this.leftRunnable);
        this.bottomThread = new Thread(this.bottomRunnable);
        this.rightThread = new Thread(this.rightRunnable);

        this.leftThread.start();
        this.bottomThread.start();
        this.rightThread.start();

//        this.koch.generateLeftEdge();
//        this.koch.generateBottomEdge();
//        this.koch.generateRightEdge();
//        
//        this.generationTime.setEnd("Einde van de generate methodes");
//
//        this.drawEdges();
//        this.application.setTextCalc(this.generationTime.toString());
//        this.application.setTextNrEdges("" + this.koch.getNrOfEdges());
    }

    public void drawEdges() {
        this.application.clearKochPanel();

        TimeStamp ts = new TimeStamp();

        ts.setBegin("Draw Start");

        for (Edge e : this.edges) {
            this.application.drawEdge(e);
        }

        ts.setEnd("Draw End");

        this.application.setTextDraw(ts.toString());
        this.application.setTextCalc(this.generationTime.toString());
        this.application.setTextNrEdges("" + this.koch.getNrOfEdges());
    }

//    @Override
//    public void update(Observable o, Object arg) {
//        this.edges.add((Edge) arg);
//    }
//    
    public synchronized void addEdge(Edge e) {
        this.edges.add(e);
    }

    public synchronized void incrementCount() {
        this.count++;

        if (this.count >= 3) {
            this.generationTime.setEnd("Generation End");
            this.application.requestDrawEdges();
            this.count = 0;
        }
    }
}
