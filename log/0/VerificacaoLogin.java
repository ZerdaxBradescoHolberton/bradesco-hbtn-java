import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerificacaoLogin {

    private static Logger logger = LoggerFactory.getLogger(VerificacaoLogin.class);

    public static void main(String[] args) {
        logger.info("Tentativa de login com o usuário: admin");
        logger.info("Login bem-sucedido para o usuário: admin");
        logger.info("Tentativa de login com o usuário: admin");
        logger.error("Senha incorreta para o usuário: admin");
        logger.info("Tentativa de login com o usuário: usuarioDesconhecido");
        logger.warn("Usuário usuarioDesconhecido não encontrado!");
    }

}