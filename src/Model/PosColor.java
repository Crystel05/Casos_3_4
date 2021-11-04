package Model;

public class PosColor {

    private Color color;
    private int posInicial;
    private int posFinal;

    public PosColor(Color color, int posInicial, int posFinal) {
        this.color = color;
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    public PosColor() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
            this.color = color;
    }

    public int getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int posInicial) {
        this.posInicial = posInicial;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }
}
