public class Produtor extends Thread {

    private Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                System.out.printf("Item adicionado: %d%n", fila.adicionar((int) (Math.random() * 101)));
                notifyAll();
            }
        }
    }
}