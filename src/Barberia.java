import java.util.ArrayList;
import java.util.List;

public class Barberia {

    Barbero barbero;
    int capClientes;

    List<Cliente> listaClientes;

    public Barberia(Barbero barbero, int capClientes){
        this.barbero = barbero;
        this.capClientes = capClientes;
        this.listaClientes = new ArrayList<>();
    }

    // TODO Cortar pelo a cliente

    // TODO Entrar
    public void entrar(Cliente cliente){
        if (listaClientes.size() < capClientes){
            listaClientes.add(cliente);
            System.out.println(cliente.getName() + " ha entrado a esperar.");
        } else {
                System.out.println(cliente.getName() + " no ha entrado porque estaba llena.");
        }
    }

    public void cortarPelo(){
        synchronized (listaClientes){
            if (listaClientes.size() == 0){
                barbero.dormir();
            } else {
                Cliente tmpCliente = listaClientes.get(0);
                listaClientes.remove(0);
                try {
                    Thread.sleep((long) (Math.random()*3500)+3000);
                    tmpCliente.setPeloCortado();
                    notifyAll();
                    System.out.println("CORTANDO - " + tmpCliente.getName() + ".");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}