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
    private final List<Edge> edges;
    private TimeStamp generationTime;
    private Thread leftThread, bottomThread, rightThread;
    private int count;

    public KochManager(JSF31KochFractalFX application) {
        this.application = application;
        this.koch = new KochFractal();
//        this.koch.addObserver(this);
        this.edges = Collections.synchronizedList(new ArrayList<Edge>());
        this.count = 0;
    }

    public void changeLevel(int nxt) {
        this.koch.setLevel(nxt);
        this.edges.clear();

        this.generationTime = new TimeStamp();
        
        this.generationTime.setBegin("Generation Start");

        this.leftThread = new Thread(new MyRunnable(this, nxt, "L"));
        this.bottomThread = new Thread(new MyRunnable(this, nxt, "B"));
        this.rightThread = new Thread(new MyRunnable(this, nxt, "R"));

        this.leftThread.start();
        this.bottomThread.start();
        this.rightThread.start();

//        this.koch.generateLeftEdge();
//        this.koch.generateBottomEdge();
//        this.koch.generateRightEdge();
//        
//        this.generationTime.setEnd("Generation End");
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
