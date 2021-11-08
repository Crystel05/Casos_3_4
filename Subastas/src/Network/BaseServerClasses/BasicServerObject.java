package Network.BaseServerClasses;

import Network.ObserverPattern.IObservable;
import Network.ObserverPattern.IObserver;

import java.io.IOException;
import java.util.ArrayList;

public class BasicServerObject implements IObservable {

    ArrayList<IObserver> observadores;
    int idClient;

    public BasicServerObject(int idClient) {
        this.idClient = idClient;
        this.observadores = new ArrayList<>();
    }

    public ArrayList<IObserver> getObservadores() {
        return observadores;
    }

    public void setObservadores(ArrayList<IObserver> observadores) {
        this.observadores = observadores;
    }

    public int getIdClient() {
        return idClient;
    }

    @Override
    public void updateAll() throws IOException {
        for (IObserver observer:observadores) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observadores.add(observer);
    }
}
