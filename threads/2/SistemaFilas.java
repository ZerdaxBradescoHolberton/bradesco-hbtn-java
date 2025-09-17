public class SistemaFilas {

    public static void main(String[] args) {

        Fila fila = new Fila(10);

        Thread tp1 = new Produtor(fila);
        Thread tp2 = new Produtor(fila);
        Thread tc1 = new Consumidor(fila);
        Thread tc2 = new Consumidor(fila);

        try {
            tp1.start();
            tp2.start();
            Thread.sleep(5000);
            tc1.start();
            tc2.start();
            Thread.sleep(15000);
            tp1.interrupt();
            tp2.interrupt();
            tc1.interrupt();
            tc2.interrupt();
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //    public SistemaFilas() {
//    }
//

//    public static void main(String[] var0) {
//        Fila var1 = new Fila(10);
//        Produtor var2 = new Produtor(var1);
//        Produtor var3 = new Produtor(var1);
//        Consumidor var4 = new Consumidor(var1);
//        Consumidor var5 = new Consumidor(var1);
//        var2.start();
//        var3.start();
//
//        try {
//            Thread.sleep(5000L);
//            var4.start();
//            var5.start();
//            var3.interrupt();
//            Thread.sleep(5000L);
//            var2.interrupt();
//            Thread.sleep(10000L);
//            System.out.println("Encerrando o sistema...");
//            System.exit(0);
//        } catch (InterruptedException var7) {
//            var7.printStackTrace();
//        }
//

//    }

}