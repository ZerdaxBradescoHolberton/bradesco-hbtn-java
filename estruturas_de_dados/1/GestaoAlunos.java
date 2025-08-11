import java.util.ArrayList;

public class GestaoAlunos implements GestaoAlunosIfc {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void excluirAluno(String nome) {
        Aluno aluno = alunos.stream().filter(aluno1 -> nome.equals(aluno1.getNome()))
                .findAny().orElse(null);
        alunos.remove(aluno);
    }

    @Override
    public void buscarAluno(String nome) {
        Aluno aluno = alunos.stream().filter(aluno1 -> nome.equals(aluno1.getNome()))
                .findAny().orElse(null);
        System.out.println(aluno);
    }

    @Override
    public void listarAlunos() {
        alunos.stream().forEach(System.out::println);
    }
}

interface GestaoAlunosIfc {
    public void adicionarAluno(Aluno aluno);
    public void excluirAluno(String nome);
    public void buscarAluno(String nome);
    public void listarAlunos();
}