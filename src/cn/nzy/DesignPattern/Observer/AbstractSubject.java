package cn.nzy.DesignPattern.Observer;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Created by nizy on 2019/3/13.
 */
public abstract class AbstractSubject implements Subject {
    private List<Observer> vector = new ArrayList<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : vector) {
            observer.update();
        }
    }
}
