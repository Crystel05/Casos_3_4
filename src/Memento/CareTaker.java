package Memento;

import java.util.ArrayList;

public class CareTaker {

    private ArrayList<Memento> estados = new ArrayList<>();
    private int estadoActual;

    public CareTaker(int estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void addEstados(Memento estado) {
        this.estados.add(estado);
    }

    public Memento getMementoActual() {
        return estados.get(estadoActual);
    }

    public Memento getSiguienteMemento() {
        int newIndex = estadoActual +1;
        if( newIndex >= estados.size()){
            return null;
        }

        estadoActual = newIndex;
        return getMementoActual();
    }

    public Memento getMementoAnterior() {
        int newIndex = estadoActual-1;

        if(newIndex  <= -1 || newIndex >= estados.size()-1){
            return null;
        }
        estadoActual = newIndex;

        return getMementoActual();
    }

}
