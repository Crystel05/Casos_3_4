package Memento;

import java.util.ArrayList;

public class CareTaker {

    private ArrayList<Memento> estados = new ArrayList<>();
    private int index;
    private Memento estadoActual;

    public CareTaker(int index, Memento estadoActual) {
        this.index = index;
        this.estadoActual = estadoActual;
    }

    public ArrayList<Memento> getEstados() {
        return estados;
    }

    public void addEstados(Memento estado) {
        this.estados.add(estado);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Memento getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Memento estadoActual) {
        this.estadoActual = estadoActual;
    }
}
