import java.util.*;
import atividades.Atividade;

public class Workflow {

    private final List<Atividade> atividades = new ArrayList<>();

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void registrarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

}