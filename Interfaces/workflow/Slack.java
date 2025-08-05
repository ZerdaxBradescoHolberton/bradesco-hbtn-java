public class Slack implements CanalNotificacao {
    @Override
    public void notificar(Mensagem mensagem) {
        System.out.printf("[SLACK] {%s} - %s", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
}