package Fabrica;

class Trabajador implements Runnable {
    private Fabrica fabrica;
    int puesto;

    public Trabajador(Fabrica fabrica, int puesto) {
        this.fabrica = fabrica;
        this.puesto = puesto;
    }

    @Override
    public void run() {
        for(;;){
            switch (puesto){
                case 0:
                    fabrica.fabricarMangas();
                    break;
                case 1:
                    fabrica.fabricarCuerpos();
                    break;
                case 2:
                    fabrica.ensamblarJerséis();
                    break;
            }
        }
    }
}