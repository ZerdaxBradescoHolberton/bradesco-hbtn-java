public class SistemaFilas {

    private static Fila fila = new Fila(10);

    public static void main(String[] args) {
        Produtor produtor = new Produtor(fila);
        Consumidor consumidor = new Consumidor(fila);
        consumidor.start();
        produtor.start();
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

}