package com.patterns.usage.behavioral.observer;

import java.util.Observable;

public class ObservedObject extends Observable {

    public void doAction(Command command)
    {
        System.out.format("Run Command: %s",command);
        System.out.println("");
        switch (command)
        {
            case CREATE : {setChanged();break;}
            case UPDATE : {setChanged();break;}
            case SELECT : {break;}
            case DELETE : {setChanged();break;}
        }
        notifyObservers(command);
    }

    public static enum Command
    {
        CREATE,UPDATE,SELECT,DELETE
    }
}
