import java.util.List;

public class ManipularArrayNumeros {
    public static int buscarPosicaoNumero(List<Integer> numeros, int numero) {
        for(int k = 0; k < numeros.size(); k++) {
            if(numeros.get(k).equals(numero)) return k;
        }
        return -1;
    }

    public static void adicionarNumero(List<Integer> numeros, int numero) {
        if(buscarPosicaoNumero(numeros, numero) > 0) throw new RuntimeException("Numero jah contido na lista");
        numeros.add(numero);
    }

    public static void removerNumero(List<Integer> numeros, int numero) {
        int pos = buscarPosicaoNumero(numeros, numero);
        if(pos < 0) throw new RuntimeException("Numero nao encontrado na lista");
        numeros.remove(pos);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int pos = buscarPosicaoNumero(numeros, numeroSubstituir);
        if(pos < 0)
            numeros.add(numeroSubstituto);
        else
            numeros.set(pos, numeroSubstituto);
    }
}