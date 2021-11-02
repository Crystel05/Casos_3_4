package Model;

import java.util.ArrayList;

public class EstadoEditor {

    private String texto;
    private ArrayList<PosColor> colorLetra;

    public EstadoEditor(String texto, ArrayList<PosColor> colorLetra) {
        this.texto = texto;
        this.colorLetra = colorLetra;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<PosColor> getColorLetra() {
        return colorLetra;
    }

    public void setColorLetra(ArrayList<PosColor> colorLetra) {
        this.colorLetra = colorLetra;
    }
}
