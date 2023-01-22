package Barberia;

import Barberia.Barberia;

public class MainBarberia {
    public static void main(String[] args) {

        Barberia barberia = new Barberia(3);
        Barbero barbero = new Barbero(barberia);
        barberia.setBarbero(barbero);

        Cliente c1 = new Cliente("Sergio",barberia);
        Cliente c2 = new Cliente("Pau",barberia);
        Cliente c3 = new Cliente("Victor",barberia);
        Cliente c4 = new Cliente("Joel",barberia);


        barbero.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}