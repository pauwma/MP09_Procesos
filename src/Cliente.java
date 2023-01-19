public class Cliente extends Thread{
    Barberia barberia;
    boolean peloCortado;

    public Cliente(Barberia barberia, String nombre){
        super(nombre);
        this.barberia = barberia;
        this.peloCortado = false;
    }

    public void setPeloCortado() {
        this.peloCortado = true;
    }

    @Override
    public void run() {
        while (!peloCortado){
            barberia.entrar(this);
        }
    }
}
