package grupozap.engzapchallengerestapi;
/*
*
* Teste da classe principal
*
 */
import grupozap.engzapchallengerestapi.util.ListarRegistros;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import static grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication.getListaCache;
import static grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication.setListaCache;

@SpringBootTest
class EngZapChallengeRestApiApplicationTests {

	@Test
	void contextLoads() {

		//Teste - Run SpringApplication
		SpringApplication.run(EngZapChallengeRestApiApplication.class, "args");

		//Teste - carrega Json em memória
		setListaCache(ListarRegistros.ListarRegistros());
		System.out.print("Carregando arquivo source-2.Json ...");
		if(getListaCache()!= null) System.out.print("cache carregado");
	}

}
