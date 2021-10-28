package Model;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class EstadoEditor {

    private String texto;
    private ArrayList<PosColor> subrayado = new ArrayList<>();

    public EstadoEditor(String texto, ArrayList<PosColor> subrayado) {
        this.texto = texto;
        this.subrayado = subrayado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<PosColor> getSubrayado() {
        return subrayado;
    }

    public void setSubrayado(ArrayList<PosColor> subrayado) {
        this.subrayado = subrayado;
    }
}
