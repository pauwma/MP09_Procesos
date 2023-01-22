package Barberia;

public class Barbero extends Thread{
    Barberia barberia;
    Cliente cliente;

    boolean dormir = false;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    public void dormir() throws InterruptedException {
        if(barberia.listaPersonas.size()==0 && dormir == false){
            System.out.println("El barbero esta durmiendo.");
            dormir = true;
        } else if (dormir == true && barberia.listaPersonas.size()!=0) {
            dormir = false;
            System.out.println("El barbero se ha despertado.");
        }

    }

    public boolean isDormir() {
        return dormir;
    }

    @Override
    public void run() {
        for(;;){
            try {
                dormir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}