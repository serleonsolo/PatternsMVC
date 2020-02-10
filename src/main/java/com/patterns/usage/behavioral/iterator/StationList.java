package com.patterns.usage.behavioral.iterator;

import com.patterns.utils.PatternHelper;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StationList implements Iterator {

    private static final int MAX_SIZE = 5;
    protected RadioStation[] radioStations = new RadioStation[MAX_SIZE];
    protected int counter;


    @Override
    public boolean hasNext() {
        return this.counter != MAX_SIZE - 1;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        else {
            this.counter ++;
            return this.radioStations[this.counter];
        }
    }

    public void add(RadioStation radioStation)
    {
        PatternHelper.print("Add frequency: " + radioStation.frequency);
        radioStations[++counter] = radioStation;
    }

    @Override
    public void remove() {
        PatternHelper.print("Remove current frequency");
        radioStations[counter] = null;
    }

    @Override
    public void forEachRemaining(Consumer consumer) {
        throw new UnsupportedOperationException();
    }

    public void reset()
    {
        counter = 0;
    }

}
