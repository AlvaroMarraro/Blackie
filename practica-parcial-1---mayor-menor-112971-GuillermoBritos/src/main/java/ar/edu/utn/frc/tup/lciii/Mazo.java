package ar.edu.utn.frc.tup.lciii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        this.inicializarMazo();

    }

    /**
     * Este metodo mescla las cartas del mazo para jugar
     * <p>
     * Ver Clase Collections
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * Este metodo crea cada carta y la agrega al mazo, como resultado retorna un mazo de 40 cartas españolas
     *
     * @return
     */
    private List<Carta> inicializarMazo() {

        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (Palo palo : Palo.values()) {
            for (String valor : valores) {
                this.cartas.add(new Carta(palo, valor));
            }
        }
        return cartas;

    }

    public Carta repartirCarta() {
        return cartas.remove(0);
    }
}
