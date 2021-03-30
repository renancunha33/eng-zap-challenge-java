package grupozap.engzapchallengerestapi.TestDAO;

import grupozap.engzapchallengerestapi.DAO.JsonConectorDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JsonConectorDAOTest {
    @Test
    public void TesteJsonConectorDAO(){
        //Declara Objeto
        JsonConectorDAO jd = new JsonConectorDAO();

        //Teste
        jd.ConectaURL();
    }
}
