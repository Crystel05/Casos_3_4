package Memento;

import Model.EstadoEditor;

public class Memento {

    private EstadoEditor estadoEditor;

    public Memento(EstadoEditor estadoEditor) {
        this.estadoEditor = estadoEditor;
    }

    public EstadoEditor getEstadoEditor() {
        return estadoEditor;
    }

    public void setEstadoEditor(EstadoEditor estadoEditor) {
        this.estadoEditor = estadoEditor;
    }
}

