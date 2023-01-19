public class Barbero extends Thread{
    Barberia barberia;

    public Barbero(){}
    public void setBarberia(Barberia barberia) {
        this.barberia = barberia;
    }

    public void dormir(){
        try {
            System.out.println("DORMIR - El barbero se ha puesto a dormir.");
            Thread.sleep((long) (Math.random()*5500)+5000);
            System.out.println("DORMIR - Ha dejado de dormir");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        barberia.cortarPelo();
    }
}