package com.desginPattern.cricketApp;

import java.util.ArrayList;
import java.util.Iterator;

public class CricketData implements Subject {
    private int runs;
    private int wickets;
    private float overs;
    private ArrayList<Observer> observerList;

    CricketData() {
        observerList = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    public void notifyObservers() {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext(); ) {
            Observer o = it.next();
            o.update(runs, wickets, overs);
        }
    }

    private int getLatestRuns() {
        return 110;
    }

    private int getLatestWickets() {
        return 4;
    }

    private float getLatestOvers() {
        return (float) 15.4;
    }

    public void dataChanged() {
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        notifyObservers();
    }
}
