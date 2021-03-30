package grupozap.engzapchallengerestapi.DAO;
/*
*
*  Classe Controller com a Conexão e validação ao source do desafio
*
*/
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class JsonConectorDAO {
    //declara variáveis necessárias
    private static HttpURLConnection connection;
    private static BufferedReader reader;
    private static String line;
    StringBuffer responseContent = new StringBuffer();

    //Método de conexão
    public StringBuffer ConectaURL() {
        try {
            //Passa a URL do source-2.JSON para a conexão via http
            URL url = new URL("http://grupozap-code-challenge.s3-website-us-east-1.amazonaws.com/sources/source-2.json");
            connection = (HttpURLConnection) url.openConnection();

            // request
            connection.setRequestMethod("GET");

            //recebe status
            int status = connection.getResponseCode();

            //valida conexão e retorna status
            //Error
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }

                //log com status da requisição/conexão
                System.out.println("Não Conectado -status: " + status);
                reader.close();
            } else {

                //Success
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }

                //log com status da requisição/conexão
                System.out.println("Conectado - status: " + status);
                reader.close();
            }
        } catch (IOException e) {
            // Retorna Exception
            e.printStackTrace();
        }
        //retorna Response
        return responseContent;
    }
}
