import java.util.Arrays;

public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        System.out.printf("Procurando o nome: \"%s\"%n", nome);
        int idxMin = 0;
        int idxMax = nomes.length - 1;
        while ((idxMax - idxMin) >= 0 && !encontrado) {
            int idx = ((idxMax - idxMin) / 2) + idxMin;
            System.out.printf("Passando pelo indice: %d%n", idx);
            int order = nome.compareTo(nomes[idx]);
            if(order == 0) {
                System.out.printf("Nome %s encontrado na posição %d%n", nome, idx);
                encontrado = true;
            }
            else if(order > 0) {
                idxMin = idx + 1;
            }
            else {
                idxMax = idx - 1;
            }
        };
        if(!encontrado)
            throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));

    }
}
