package grupozap.engzapchallengerestapi.util;
/*
 *
 *  Classe Controller Lista a quantidade de registros no arquivo JSON
 *
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grupozap.engzapchallengerestapi.DAO.JsonConectorDAO;
import grupozap.engzapchallengerestapi.model.Contrato;
import java.util.List;

public class ListarRegistros {

    public static List<Contrato> ListarRegistros() {
        //Declara Lista
        List<Contrato> Listcon = null;

        //Declara ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Recebe string JSON
        String json = new JsonConectorDAO().ConectaURL().toString();

        try {
            //Desserializa JSON e aloca na lista
            Listcon = objectMapper.readValue(json, new TypeReference<List<Contrato>>() {
            });
        } catch (
                JsonMappingException e) {
            e.printStackTrace();
        } catch (
                JsonProcessingException e) {
            e.printStackTrace();
        }
        //Retorna Lista com Registros
        return Listcon;
    }
}
