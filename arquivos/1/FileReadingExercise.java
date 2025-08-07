import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReadingExercise {
    public static void main(String[] args) throws Exception {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura


        // efetue a leitura do arquivo
        System.out.printf("Conteúdo do arquivo 'exemplo.txt':%n%n");
        Files.readAllLines(Path.of(fileName)).forEach(System.out::println);
        System.out.printf("%nLeitura do arquivo concluída.");
    }
}