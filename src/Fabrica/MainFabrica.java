package Fabrica;

public class MainFabrica {

    public static void main(String[] args) {
        Fabrica fabrica = new Fabrica(4,3);

        Trabajador costurera1 = new Trabajador(fabrica, 0);
        Trabajador costurera2 = new Trabajador(fabrica, 1);
        Trabajador ensamblador = new Trabajador(fabrica, 2);

        Thread h1 = new Thread(costurera1);
        Thread h2 = new Thread(costurera2);
        Thread h3 = new Thread(ensamblador);

        h1.start();
        h2.start();
        h3.start();

    }
}