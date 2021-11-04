package Network.ObserverPattern;

import java.util.ArrayList;

public class ConcreteObservable implements IObservable{

    ArrayList<IObserver> observadores;

    @Override
    public void updateAll() {
        for (IObserver observer:observadores) {
            observer.update();
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observadores.add(observer);
    }
}
