import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        Map<String, List<Pessoa>> cargoPessoas = new HashMap<>();
        pessoas.stream().map(Pessoa::getCargo).distinct()
                .forEach(s -> cargoPessoas.put(s, pessoas.stream()
                        .filter(pessoa -> s.equals(pessoa.getCargo()))
                        .collect(Collectors.toCollection(ArrayList::new))));
        return cargoPessoas;
    }
}