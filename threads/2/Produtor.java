public class Produtor extends Thread {

    private Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 101);
                fila.adicionar(item);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}