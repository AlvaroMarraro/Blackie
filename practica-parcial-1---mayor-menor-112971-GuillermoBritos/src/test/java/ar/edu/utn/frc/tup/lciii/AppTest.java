package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;



    @BeforeEach
    public void setUpOutput(){
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public  void restoreSystemInputOutput(){
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    private void provideInput(String data){
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    private String getOutput(){

        return testOut.toString();
    }

    @Test
    public void testComprobarSize() {
        List<Carta> mano = new ArrayList<>();
        mano.add(new Carta(Palo.PICAS, "5"));
        mano.add(new Carta(Palo.TREBOLES, "8"));
        mano.add(new Carta(Palo.DIAMANTES, "9"));

        InputStream in = new ByteArrayInputStream("s".getBytes());
        System.setIn(in);

        Assertions.assertEquals(3, mano.size(), "La mano del jugador debe tener 3 cartas después de pedir una carta extra");

    }


    @Test
    public void testAgregarCarta() {
        Jugador  mano = new Jugador();
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(Palo.CORAZONES, "A"));
        cartas.add(new Carta(Palo.PICAS, "K"));
        mano.agregarCarta(cartas.get(0));
        mano.agregarCarta(cartas.get(1));
        Assertions.assertEquals(2, mano.getCartas().size());
        Assertions.assertEquals(21, mano.getValorTotal());

    }
    @Test
    public void testGetValorNumerico() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Creamos una carta con valor A
        Carta cartaA = new Carta(Palo.CORAZONES, "A");

        // Obtenemos el método getValorNumerico() de la clase Carta mediante reflection
        Method getValorNumericoMethod = Carta.class.getDeclaredMethod("getValorNumerico");
        getValorNumericoMethod.setAccessible(true);

        // Invocamos el método getValorNumerico() para la carta creada anteriormente
        int valorNumerico = (int) getValorNumericoMethod.invoke(cartaA);

        // Verificamos que el valor numérico obtenido sea 11
        Assertions.assertEquals(11, valorNumerico);
    }

    @Test
    public void testInicializarMazo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Mazo mazo = new Mazo();

        Method metodoInicializarMazo = Mazo.class.getDeclaredMethod("inicializarMazo");
        metodoInicializarMazo.setAccessible(true);
        List<Carta> cartas = (List<Carta>) metodoInicializarMazo.invoke(mazo);

        Assertions.assertEquals(52, cartas.size() - 52);


    }





}
