public class Numero {
    public static void dividir(int a, int b) {
        int result = 0;
        try {
            result = a/b;
        } catch (Exception e) {
            System.out.println("Nao eh possivel dividir por zero");
        } finally {
            System.out.printf("%s / %s = %s%n", a, b, result);
        }
    }
}