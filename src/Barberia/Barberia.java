package Barberia;

import java.util.ArrayList;
import java.util.List;

public class Barberia{
    Barbero barbero;
    int capClientes;
    boolean sillaOcupada = false;
    List<Cliente> listaPersonas = new ArrayList<>();

    public Barberia(int capClientes) {
        this.capClientes=capClientes;
    }

    public synchronized void entrar(Cliente cliente) throws InterruptedException {
        if(listaPersonas.size() < capClientes ){
            listaPersonas.add(cliente);
            System.out.println(cliente.getName() +" ha entrado en la barberia");
            cortarPelo(cliente);
        } else {
            System.out.println(cliente.getName()+ " no ha entrado porque estaba llena");
            Thread.sleep((long) ((Math.random()*1000)+3000));
        }
    }

    public synchronized void cortarPelo(Cliente cliente) throws InterruptedException {
        while (sillaOcupada == false){
            if(barbero.isDormir() == false){
                System.out.println(cliente.getName() +" se esta cortando el pelo");
                sillaOcupada = true;    // Ocupa la silla
                listaPersonas.remove(0);    // Se libera un hueco en las sillas de espera
                Thread.sleep((long) ((Math.random()*5000)+5000));   // Tiempo de corte
                sillaOcupada=false;     // Liberación de silla del peluquero
                notifyAll();    // Notificación
            }
            wait();
        }

    }
    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }
}