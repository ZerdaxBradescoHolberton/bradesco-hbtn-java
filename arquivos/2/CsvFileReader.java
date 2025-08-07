import java.io.BufferedReader;
import java.io.FileReader;

public class CsvFileReader {
    public static void main(String[] args) throws Exception {
        String fileName = "funcionarios.csv";

        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            br.lines().forEach(s -> {
                String[] values = s.split(",", -1);
                System.out.printf("Funcionário: %s%n" +
                        "Idade: %s%n" +
                        "Departamento: %s%n" +
                        "Salarial: %s%n" +
                        "------------------------%n",
                        values[0], values[1], values[2], values[3]);
            });
            System.out.println("Leitura do arquivo concluída.");
        }
    }
}