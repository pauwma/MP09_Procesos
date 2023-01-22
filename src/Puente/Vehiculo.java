package Puente;

class Vehiculo implements Runnable {
    private Puente puente;
    private String direccion;

    public Vehiculo(Puente puente, String direccion) {
        this.puente = puente;
        this.direccion = direccion;
    }
    private void llegarAlPuente(String direccion) {
        System.out.println("Vehículo llegó al puente en dirección " + direccion);
    }
    private void salirDelPuente() {
        System.out.println("Vehículo salió del puente");
    }
    private void cruzarPuente(String direccion) {
        puente.cruzarPuente(direccion);
    }
    public void run() {
        llegarAlPuente(direccion);
        cruzarPuente(direccion);
        salirDelPuente();
    }
}