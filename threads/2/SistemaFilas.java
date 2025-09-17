public class SistemaFilas {

    private static Fila fila = new Fila(10);

    public static void main(String[] args) {
        Produtor produtor = new Produtor(fila);
        Consumidor consumidor = new Consumidor(fila);
        long tInicial = System.currentTimeMillis();
        consumidor.start();
        produtor.start();
        while ((System.currentTimeMillis() - tInicial) < 20000) continue;
        System.exit(0);
    }

}