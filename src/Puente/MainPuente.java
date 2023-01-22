package Puente;
public class MainPuente {
    public static void main(String[] args) {
        Puente puente = new Puente();
        for (int i = 0; i < 6; i++) {
            Thread vehiculoIzq = new Thread(new Vehiculo(puente, "izquierda"));
            vehiculoIzq.start();
            Thread vehiculoDer = new Thread(new Vehiculo(puente, "derecha"));
            vehiculoDer.start();
        }
    }
}