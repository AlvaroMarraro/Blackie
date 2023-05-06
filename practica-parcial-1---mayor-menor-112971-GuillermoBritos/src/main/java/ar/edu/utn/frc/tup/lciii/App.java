package ar.edu.utn.frc.tup.lciii;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Hello to Practica Parcial 1 - MAYOR/MENOR
 */
public class App {

    /**
     * This is the main program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mazo mazo = new Mazo();
        mazo.barajar();
        Jugador jugador = new Jugador("Jugador");
        Jugador banca = new Jugador("Banca");
        System.out.println("¡Bienvenido al Blackjack!");
        // El jugador recibe dos cartas al inicio
        jugador.agregarCarta(mazo.repartirCarta());
        jugador.agregarCarta(mazo.repartirCarta());

        System.out.println("Tus cartas son:");
        jugador.mostrarCartas();




        // La banca recibe dos cartas al inicio
        banca.agregarCarta(mazo.repartirCarta());
        banca.agregarCarta(mazo.repartirCarta());
        System.out.println("Las  cartas de la banca son:");
        banca.mostrarCartas();
        // Si el jugador tiene blackjack, gana automáticamente
        if (jugador.getValorTotal() == 21) {
            System.out.println("¡Blackjack! ¡Felicidades, ganaste!");
            return;
        }

        // Mientras el jugador no se pase de 21, puede pedir más cartas
        while (jugador.getValorTotal() < 21) {
            System.out.print("¿Quieres pedir otra carta? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("s")) {
                jugador.agregarCarta(mazo.repartirCarta());
                System.out.println("Tus cartas son:");
                jugador.mostrarCartas();
                if (jugador.getValorTotal() > 21) {
                    System.out.println("Te has pasado de 21. ¡Lo siento, perdiste!");
                    return;
                }
            } else {
                break;
            }
        }

        // Si la banca tiene blackjack, gana automáticamente
        if (banca.getValorTotal() == 21) {
            System.out.println("La banca tiene blackjack. ¡Lo siento, perdiste!");
            return;
        }

        // La banca empieza a jugar si el jugador no ha perdido
        while (banca.getValorTotal() < 17) {
            banca.agregarCarta(mazo.repartirCarta());
        }
        System.out.println("Las cartas de la banca son:");
        banca.mostrarCartas();

        // Comparamos las manos del jugador y la banca
        if (banca.getValorTotal() > 21) {
            System.out.println("La banca se ha pasado de 21. ¡Felicidades, ganaste!");
        } else if (jugador.getValorTotal() > banca.getValorTotal()) {
            System.out.println("¡Felicidades, ganaste!");
        } else if (jugador.getValorTotal() == banca.getValorTotal()) {
            System.out.println("¡Empate!");
        } else {
            System.out.println("Lo siento, perdiste!");
        }
    }
}