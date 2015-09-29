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
public class KochManager implements Observer {

    private JSF31KochFractalFX application;
    private KochFractal koch;
    private ArrayList<Edge> edges;

    public KochManager(JSF31KochFractalFX application) {
        this.application = application;
        this.koch = new KochFractal();
        this.koch.addObserver(this);
        this.edges = new ArrayList<>();
    }

    public void changeLevel(int nxt) {
        this.koch.setLevel(nxt);
        this.edges.clear();

        TimeStamp ts = new TimeStamp();

        ts.setBegin("Begin van de generate methodes");

        this.koch.generateLeftEdge();
        this.koch.generateBottomEdge();
        this.koch.generateRightEdge();

        ts.setEnd("Einde van de generate methodes");

        this.drawEdges();
        this.application.setTextCalc(ts.toString());
        this.application.setTextNrEdges("" + this.koch.getNrOfEdges());
    }

    public void drawEdges() {
        this.application.clearKochPanel();

        TimeStamp ts = new TimeStamp();

        ts.setBegin("Begin van de for-loop");

        for (Edge e : this.edges) {
            this.application.drawEdge(e);
        }

        ts.setEnd("Einde van de for-loop");

        this.application.setTextDraw(ts.toString());
    }

    @Override
    public void update(Observable o, Object arg) {
        this.edges.add((Edge) arg);
    }
}
