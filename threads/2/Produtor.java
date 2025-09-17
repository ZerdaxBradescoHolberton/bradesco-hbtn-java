import java.util.Random;

public class Produtor extends Thread {

    private Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                fila.adicionar(new Random().nextInt(100) + 1);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}