public class Principal {


    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread t1 = new ThreadContador(contador);
        Thread t2 = new ThreadContador(contador);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Valor final do contador: %d%n", contador.getContagem());
    }
}