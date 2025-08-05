public class Email implements CanalNotificacao {
    @Override
    public void notificar(Mensagem mensagem) {
        System.out.printf("[EMAIL] {%s} - %s", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
}