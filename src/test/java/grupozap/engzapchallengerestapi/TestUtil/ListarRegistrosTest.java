package grupozap.engzapchallengerestapi.TestUtil;

import grupozap.engzapchallengerestapi.util.ListarRegistros;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ListarRegistrosTest {

    @Test
    public void ListarRegistrosTeste(){
        ListarRegistros lr = new ListarRegistros();

        lr.ListarRegistros();
    }
}
