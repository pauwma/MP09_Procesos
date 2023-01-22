package Barberia;

public class Cliente extends Thread{
    Barberia barberia;

    public Cliente(String nombre, Barberia barberia){
        super(nombre);
        this.barberia = barberia;
    }

    @Override
    public void run() {
        for(;;){
            try {
                barberia.entrar(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
