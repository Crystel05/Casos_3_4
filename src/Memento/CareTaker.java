package Memento;

import java.util.ArrayList;

public class CareTaker {

    private ArrayList<Memento> estados;
    private int estadoActual;
    private static CareTaker careTaker_singleton = null;

    private CareTaker() {
        this.estados = new ArrayList<>();
        this.estadoActual = -1;
    }

    public static CareTaker getInstance()
    {
        if (careTaker_singleton == null)
            careTaker_singleton = new CareTaker();

        return careTaker_singleton;
    }

    public void addEstados(Memento estado) {
        this.estados.add(estado);
        estadoActual++;
    }

    public Memento getMementoActual() {
        return estados.get(estadoActual);
    }

    public Memento getSiguienteMemento() {

//        System.out.println("estado actual"+estadoActual);
        int newIndex = estadoActual+1;
//        System.out.println("estado siguiente"+newIndex);
        if (newIndex > estados.size()) {
//            System.out.println("No mas indices adelante");
            return null;
        }
        estadoActual = newIndex;
        Memento mem = getMementoActual();
        return mem;
    }

    public Memento getMementoAnterior() {

        int newIndex = estadoActual;
        Memento mem = getMementoActual();
        estadoActual = newIndex - 1;
        if (estadoActual < 0) {
//            System.out.println("No mas indices atras");
            estadoActual = 0;
        }
        return mem;
    }

    public ArrayList<Memento> getEstados() {
        return estados;
    }
}
