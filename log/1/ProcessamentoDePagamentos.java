import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.Random;


public class ProcessamentoDePagamentos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);


    public static void main(String[] args) {

        Random random = new Random();
        for(int n = 1; n < 6; n++) {
            Level level = Level.intToLevel((random.nextInt(3) + 2) * 10);
            logger.info("Iniciando o processamento do pagamento {}", n);
            switch (level) {
                case INFO:
                    logger.info("Pagamento {} processado com sucesso.", n);
                    break;
                case WARN:
                    logger.warn("Pagamento {} está pendente. Aguardando confirmação.", n);
                    break;
                case ERROR:
                    logger.error("Erro ao processar o pagamento {}: Falha na transação.", n);
                    break;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}