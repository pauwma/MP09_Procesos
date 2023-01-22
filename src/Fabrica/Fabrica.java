package Fabrica;

class Fabrica {

    private int numMangas, numCuerpos;
    private int capCestaMangas;
    private int capCestaCuerpos;
    boolean llenaCestaMangas;
    boolean llenaCestaCuerpos;


    public Fabrica(int cestaMangas, int cestaCuerpos) {
        this.capCestaMangas = cestaMangas;
        this.capCestaCuerpos = cestaCuerpos;
        numMangas = 0;
        numCuerpos = 0;
    }

    public void fabricarMangas() {
        if (numMangas < capCestaMangas) {
            llenaCestaMangas = false;
            numMangas++;
            System.out.println("Fabricando manga - " + numMangas);
            // notifyAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (llenaCestaMangas == false){
                llenaCestaMangas = true;
                System.out.println("LLENO - Cesto de mangas");
            }
        }
    }


    public void fabricarCuerpos() {
        if (numCuerpos < capCestaCuerpos) {
            llenaCestaCuerpos = false;
            numCuerpos++;
            System.out.println("Fabricando cuerpo - " + numCuerpos);
            // notifyAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (llenaCestaCuerpos == false){
                llenaCestaCuerpos = true;
                System.out.println("LLENO - Cesto de cuerpos");
            }
        }

    }

    public synchronized void ensamblarJerséis() {
        if (numCuerpos >= 1 && numMangas >= 2) {
            System.out.println("Fabricando jersey");
            numCuerpos--;
            numMangas -= 2;
            //notifyAll();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}