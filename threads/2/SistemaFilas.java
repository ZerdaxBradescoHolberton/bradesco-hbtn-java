public class SistemaFilas {

    public SistemaFilas() {
    }

    public static void main(String[] var0) {
        Fila var1 = new Fila(10);
        Produtor var2 = new Produtor(var1);
        Produtor var3 = new Produtor(var1);
        Consumidor var4 = new Consumidor(var1);
        Consumidor var5 = new Consumidor(var1);
        var2.start();
        var3.start();

        try {
            Thread.sleep(5000L);
            var4.start();
            var5.start();
            var3.interrupt();
            Thread.sleep(5000L);
            var2.interrupt();
            Thread.sleep(10000L);
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        }

    }
    
//    public static void main(String[] args) {
//
//        Fila fila = new Fila(10);
//        try {
//            new Produtor(fila).start();
//            new Produtor(fila).start();
//            Thread.sleep(5000);
//            new Consumidor(fila).start();
//            new Consumidor(fila).start();
//            Thread.sleep(15000);
//            System.exit(0);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

}