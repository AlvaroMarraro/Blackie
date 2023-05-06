package ar.edu.utn.frc.tup.lciii;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
 private Carta carta = new Carta();
    private List<Carta> cartas = new ArrayList<>();

    public Jugador() {

    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartas = new ArrayList<Carta>();


    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void mostrarCartas() {
        for (Carta carta : this.cartas) {
            System.out.print(carta.getPalo() +" "+ carta.getValor() + ", ");
        }
        System.out.println();
    }

    public int getValorTotal() {
        int valorTotal = 0;
        int ases = 0;
        for (Carta carta : this.cartas) {
            int valor = carta.getValorNumerico();
            if (valor == 11) {
                ases++;
            }
            valorTotal += valor;
        }
        while (ases > 0 && valorTotal > 21) {
            valorTotal -= 10;
            ases--;
        }
        return valorTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
