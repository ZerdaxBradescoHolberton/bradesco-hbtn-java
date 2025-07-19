import atividades.Atividade;

public class MaquinaWorkflow {

    public void executar(Workflow workflow) {
        workflow.getAtividades().forEach(Atividade::executar);
    }

}