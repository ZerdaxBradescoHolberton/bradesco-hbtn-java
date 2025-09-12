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

    // implementar o método de buscaLinear
    public void buscaLinear(String nome){
        System.out.printf("Procurando pelo nome: \"%s\"%n", nome);
        boolean encontrado = false;
        for (int k = 0; k < nomes.length; k++) {
            System.out.printf("Passando pelo indice:%d%n", k);
            if(nomes[k].equals(nome)) {
                System.out.printf("Nome pesquisado é %s que está na posição %d%n", nomes[k], k);
                encontrado = true;
            }
        }
        if(!encontrado)
            throw new IllegalArgumentException(String.format("O nome %s não se encontra no array de nomes", nome));
    }
}