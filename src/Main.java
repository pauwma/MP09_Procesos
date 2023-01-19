public class Main {
    public static void main(String[] args) {

        Barbero barbero = new Barbero();
        Barberia barberia = new Barberia(barbero,3);
        barbero.setBarberia(barberia);

        Cliente c1 = new Cliente(barberia,"Paco");
        Cliente c2 = new Cliente(barberia,"Eva");
        Cliente c3 = new Cliente(barberia,"Manu");
        Cliente c4 = new Cliente(barberia,"María");
        Cliente c5 = new Cliente(barberia,"Zerhio");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        barbero.start();
    }
}