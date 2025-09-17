public class Principal {


    private static Contador contador;
    private static Thread[] threads = new Thread[2];
    public static void main(String[] args) {
        contador = new Contador();
        new ThreadContador(contador).start();
        new ThreadContador(contador).start();
        while(Thread.activeCount() > 2) {
//            System.out.println(Thread.activeCount());
//            System.out.println(Thread.activeCount());
            continue;
        }
        System.out.printf("Valor final do contador: %d%n", contador.getContagem());
//        executaThreads();
    }

    private static void executaThreads() {
        for(int t = 0; t < 2; t++) {
            threads[t] = new ThreadContador(contador);
            threads[t].start();
        }

        boolean concludedThread = false;
        while(!concludedThread) {
            concludedThread = true;
            for(Thread thread : threads) {
                if(thread.isAlive()) {
                    concludedThread = false;
                    break;
                }
            }
        }

        System.out.printf("Valor final do contador: %d%n", contador.getContagem());

    }

}