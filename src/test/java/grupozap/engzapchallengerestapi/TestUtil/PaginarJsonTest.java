package grupozap.engzapchallengerestapi.TestUtil;
/*
*
* Teste da Paginação do JSON
*
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import grupozap.engzapchallengerestapi.util.ListarRegistros;
import grupozap.engzapchallengerestapi.model.Contrato;
import grupozap.engzapchallengerestapi.util.PaginarJson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
public class PaginarJsonTest {

    @Test
    void TesteGetPageContrato() throws Exception {

        //Declaração das variáveis e objetos necessários
        ListarRegistros lc = new ListarRegistros();
        final ObjectMapper objectMapper = new ObjectMapper();
        PaginarJson PgTeste = new PaginarJson();
        String json;

        List<Contrato> listaTeste = lc.ListarRegistros();
        //Teste (Lista<Contrato>, tamanho da pagina, qtd de elementos na pagina, qtd de elementos total)
        PgTeste.getPageContrato(listaTeste, 15, 75, listaTeste.size());

    }
}
