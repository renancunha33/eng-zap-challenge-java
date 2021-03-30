package grupozap.engzapchallengerestapi.TestController;

import grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication;
import grupozap.engzapchallengerestapi.util.ListarRegistros;
import grupozap.engzapchallengerestapi.controller.VivaRealController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication.setListaCache;

@SpringBootTest
public class VivaVidaControllerTest {

    @Test
    void TesteVivaVidaController() throws Exception {
        //Instancia Objeto
        VivaRealController vivareal = new VivaRealController();

        //inicia Servidor
        SpringApplication.run(EngZapChallengeRestApiApplication.class, "args");

        //carrega Json em memória
        setListaCache(ListarRegistros.ListarRegistros());

        //Teste das condicionais do Controller
        vivareal.VivaRealController(5, 10);
    }

}
