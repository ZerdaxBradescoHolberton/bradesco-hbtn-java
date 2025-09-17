public class SistemaFilas {

    private static Fila fila = new Fila(10);

    public static void main(String[] args) {

        try {
            new Produtor(fila).start();
            new Produtor(fila).start();
            new Consumidor(fila).start();
            new Consumidor(fila).start();
            Thread.sleep(20000L);
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}