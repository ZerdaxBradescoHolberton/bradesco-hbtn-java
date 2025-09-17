import java.util.LinkedList;

public class Fila {
    private int limite;
    private LinkedList<Integer> fila;

    public Fila(int limite) {
        this.limite = limite;
        fila = new LinkedList<>();
    }

    public LinkedList<Integer> getFila() {
        return fila;
    }

    public void setFila(LinkedList<Integer> fila) {
        this.fila = fila;
    }

    public synchronized int adicionar(int item) {
        while(fila.size() > limite) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        fila.add(item);
        notifyAll();
        return item;
    }

    public synchronized int retirar() {
        while (fila.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int result = fila.getLast();
        fila.removeLast();
        notifyAll();
        return result;
    }
}