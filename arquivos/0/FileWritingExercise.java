import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


        // implemente o codigo aqui
        createFile(fileName);



        scanner.close();
    }

    private static void createFile(String fileName) throws Exception {
        if("sair".equals(fileName))
            System.exit(0);
        if(!Files.exists(Path.of(fileName))) {
            Files.createFile(Path.of(fileName));
            System.out.println("Arquivo criado com sucesso");
            main(null);
        }
    }
}