import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaTodo {
    private List<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.stream().filter(tarefa1 -> tarefa1.getIdentificador() == tarefa.getIdentificador())
                .findAny().ifPresent(tarefa1 -> {throw new IllegalArgumentException(String
                        .format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador()));});
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        boolean isDone = false;
        Tarefa tarefaFeita = tarefas.stream().filter(tarefa -> tarefa.getIdentificador() == identificador)
                .findFirst().orElse(null);
        if(Objects.nonNull(tarefaFeita)) {
            tarefaFeita.setEstahFeita(true);
            isDone = true;
        }
        return isDone;
    }

    public boolean desfazerTarefa(int identificador) {
        boolean isDone = false;
        Tarefa tarefaFeita = tarefas.stream().filter(tarefa -> tarefa.getIdentificador() == identificador)
                .findFirst().orElse(null);
        if(Objects.nonNull(tarefaFeita)) {
            tarefaFeita.setEstahFeita(false);
            isDone = true;
        }
        return isDone;
    }

    public void desfazerTodas() {
        tarefas.forEach(tarefa -> tarefa.setEstahFeita(false));
    }

    public void fazerTodas() {
        tarefas.forEach(tarefa -> tarefa.setEstahFeita(true));
    }

    public void listarTarefas() {
        tarefas.forEach(tarefa -> {
            String marcacao = tarefa.isEstahFeita() ? "X" : " ";
            System.out.printf("[%s]  Id: %d - Descricao: %s%n", marcacao,
                    tarefa.getIdentificador(), tarefa.getDescricao());
        });
    }

}