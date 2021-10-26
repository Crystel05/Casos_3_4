package Model;

import ObserverPattern.IObserver;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Subasta {

    int subastaId;
    ArrayList<IObserver> oferentes;
    Producto producto;
    Date inicio;
    Date fin;
    EstadosSubasta estado;

    public int getSubastaId() {
        return subastaId;
    }

    public ArrayList<IObserver> getOferentes() {
        return oferentes;
    }

    public Producto getProducto() {
        return producto;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public EstadosSubasta getEstado() {
        return estado;
    }

    public Subasta(int subastaId, Producto producto){
        this.oferentes = new ArrayList<>();
        estado = EstadosSubasta.ACTIVO;
        this.producto = producto;
        this.subastaId = subastaId;
        inicio = new Date();
    }

    public void cerrar(){
        if(estado.equals(EstadosSubasta.ACTIVO)){
            estado = EstadosSubasta.TERMINADO;
            fin = new Date();
        }
    }
    public void cancelar(){
        if(!estado.equals(EstadosSubasta.CANCELADO)){
            estado = EstadosSubasta.CANCELADO;
            fin = new Date();
        }
    }

    public void incrementarPrecio(double precio){
        if(estado.equals(EstadosSubasta.ACTIVO) && precio > producto.getPrecioFinal()){
            producto.setPrecioFinal(precio);
        }
    }

    public void agregarOferente(ClienteSubasta oferente)
    {
        oferentes.add(oferente);
    }

}
