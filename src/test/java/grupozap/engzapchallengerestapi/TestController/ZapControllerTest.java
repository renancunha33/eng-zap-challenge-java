package grupozap.engzapchallengerestapi.TestController;

import grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication;
import grupozap.engzapchallengerestapi.util.ListarRegistros;
import grupozap.engzapchallengerestapi.controller.ZapController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication.setListaCache;

@SpringBootTest
public class ZapControllerTest {

    @Test
    void TesteZapController() throws Exception {
        //Instancia Objeto
        ZapController zap = new ZapController();

        //inicia Servidor
        SpringApplication.run(EngZapChallengeRestApiApplication.class, "args");

        //carrega Json em memória
        setListaCache(ListarRegistros.ListarRegistros());

        //Teste das condicionais do Controller
        zap.ZapController(5,5);
    }

}
