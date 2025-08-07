import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileWritingExercise {
    private static List<String> textLines = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


        // implemente o codigo aqui
        System.out.print("Digite o texto a ser gravado ou \"sair\" para encerrar.");
        String text = scanner.nextLine();
        if(!"sair".equals(fileName)) {
            textLines.add(fileName);
            main(null);
        }
        createFile(fileName);


        scanner.close();
    }

    private static void createFile(String fileName) throws Exception {
        textLines.forEach(s -> {
            if(!Files.exists(Path.of(s))) {
                try {
                    Files.createFile(Path.of(s));
                    System.out.printf("Arquivo %s criado com sucesso%n", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}