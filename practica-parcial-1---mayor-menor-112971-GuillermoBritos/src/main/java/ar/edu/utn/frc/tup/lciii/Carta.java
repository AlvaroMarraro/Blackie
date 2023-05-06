package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

public class Carta {

    private Palo palo;
    private String valor;

    public Carta(Palo palo, String valor) {

        this.palo = palo;
        this.valor = valor;

    }

    public Carta() {

    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getValorNumerico() {
        try {
            return Integer.parseInt(this.valor);
        } catch (NumberFormatException e) {
            switch (this.valor) {
                case "A":
                    return 11;
                case "J":
                case "Q":
                case "K":
                    return 10;
                default:
                    return 0;
            }
        }
    }
}
