public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Criar e iniciar as threads do produtor e consumidor
        Thread consumidor = new Consumidor(buffer);
        Thread produtor = new Produtor(buffer);

        consumidor.start();
        produtor.start();

        try {
            consumidor.join();
            produtor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}