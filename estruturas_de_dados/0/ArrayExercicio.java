import java.util.Arrays;
import java.util.Scanner;


public class ArrayExercicio {


    public static void main(String[] args) {
        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);


        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        // Preenchendo o array com números fornecidos pelo usuário
        // Utilize scanner.nextInt(); para receber o numero digitado
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite o número %s: ", i+1);
            numeros[i] = scanner.nextInt();
        }
        Integer somaArray = 0; // = Arrays.stream(numeros).reduce(0, Integer::sum);
        maiorNumero = 0;
        for(Integer n : numeros) {
            somaArray += n;
            if(n > maiorNumero) maiorNumero = n;
        }
//        maiorNumero = Arrays.stream(numeros).max().getAsInt();

        // Exibindo os resultados
        System.out.printf("%n%nConteúdo do array:%n");
        Arrays.stream(numeros).forEach(value -> System.out.printf("%s ", value));
        System.out.println("");
        System.out.printf("Soma de todos os números: %s%n", somaArray);
        System.out.printf("Maior número no array: %s%n", maiorNumero);

        // Fechando o scanner
        scanner.close();
    }
}
