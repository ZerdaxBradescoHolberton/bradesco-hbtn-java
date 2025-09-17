public class SistemaFilas {

    public static void main(String[] args) {
        Fila fila = new Fila(10);
        try {
            new Produtor(fila).start();
            new Produtor(fila).start();
            Thread.sleep(5000);
            new Consumidor(fila).start();
            new Consumidor(fila).start();
            Thread.sleep(15000);
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}