public class SistemaFilas {

    public static void main(String[] args) {

        Fila fila = new Fila(10);

        Thread tp1 = new Produtor(fila);
        Thread tp2 = new Produtor(fila);
        Thread tc1 = new Consumidor(fila);
        Thread tc2 = new Consumidor(fila);

        try {
            long tIni = System.currentTimeMillis();
            tp1.start();
            tp2.start();
            tc1.start();
            tc2.start();
            while((System.currentTimeMillis() - tIni) < 20000L) continue;
            long tFim = System.currentTimeMillis();
            System.out.printf("Tempo de execução %d%n", tFim - tIni);
            System.exit(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}