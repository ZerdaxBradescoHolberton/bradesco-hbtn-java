import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private final List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canalNotificacao) {
        canais.add(canalNotificacao);
    }

    public void processar(Video video) {

        canais.stream().forEach(canalNotificacao -> {
            canalNotificacao.notificar(new Mensagem("", TipoMensagem.LOG));
            System.out.printf("%s - %s%n",
                    video.getArquivo(), video.getFormato());
        });
    }
}