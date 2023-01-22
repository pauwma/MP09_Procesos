package Puente;

import java.util.concurrent.Semaphore;

class Puente {
    private Semaphore semaforo;
    private int vehiculosPuente;
    private String direccionActual;

    public Puente() {
        semaforo = new Semaphore(3);
        vehiculosPuente = 0;
        direccionActual = "izquierda";
    }

    public void cruzarPuente(String direccion) {
        try {
            semaforo.acquire();
            synchronized (this) {
                while (!direccion.equals(direccionActual)) {
                    wait();
                }
                vehiculosPuente++;
                System.out.println("Vehículo cruzando el puente en dirección " + direccion + ". Vehículos en el puente: " + vehiculosPuente);
            }
            Thread.sleep(1000);
            synchronized (this) {
                vehiculosPuente--;
                System.out.println("Vehículo dejando el puente. Vehículos en el puente: " + vehiculosPuente);
                if (vehiculosPuente == 0) {
                    direccionActual = direccionActual.equals("izquierda") ? "derecha" : "izquierda";
                    notifyAll();
                }
            }
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}