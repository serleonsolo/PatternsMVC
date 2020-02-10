package com.patterns.usage.behavioral.observer;

import com.patterns.usage.AbstractPatternUsage;

public class ObserverUsage extends AbstractPatternUsage {

    public ObserverUsage() {
        this.description = " ";
    }

    @Override
    public void demonstrate() {

        ObservedObject observedObject = new ObservedObject();
        Watcher watcherFirst = new Watcher(1);
        Watcher watcherSecond = new Watcher(2);

        observedObject.doAction(ObservedObject.Command.CREATE);
        observedObject.addObserver(watcherFirst);
        observedObject.doAction(ObservedObject.Command.UPDATE);
        observedObject.addObserver(watcherSecond);
        observedObject.doAction(ObservedObject.Command.SELECT);
        observedObject.doAction(ObservedObject.Command.DELETE);

    }
}
