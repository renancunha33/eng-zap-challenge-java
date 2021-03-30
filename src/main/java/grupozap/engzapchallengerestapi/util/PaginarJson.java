package grupozap.engzapchallengerestapi.util;
/*
*
* Classe retonar pagina com o tamanho solicitado + metadados
*
 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import grupozap.engzapchallengerestapi.model.Contrato;

import java.util.List;

public class PaginarJson {
    //variáveis e Objetos
    String retorno;
    List<Contrato> jsonLista;
    Metadados meta = new Metadados();

    // Metodos de criação da pagina
    public String getPageContrato(List<Contrato> buffer, int page, int size, int total) throws Exception {

        //Variáveis do Método
        int p = 0;
        int t = 0;
        jsonLista = buffer;
        retorno = meta.getHeader(page, size, total); //Retorna header do Metadados

        //Laço de repetição para total de registros recebidos
        for (int s = 0; s < total; s++) {

            //Se alcançado a pagina, é gerada com o size requisitado
            if (p == page) {
                for (int i = 0; i < size; i++) {

                    retorno += new Gson().toJson(buffer.get(t), new TypeReference<Contrato>() {
                    }.getType())+",";
                   t++;
                }
                //Finaliza for após gerar a página
                break;
            } else {
                //se size for alcançado antes da pagina ser encontrada: s é zerado e pagina recebe +1
                if (s % size == 0 && p != page) {
                    p++;
                    s = 0;
                }
                //t incrementado até loop entrar no if da página
                t++;
            }

        }
        //Remove ultima virgula
        retorno = retorno.substring(0, retorno.length() - 1);

        //insere footer do metadados
        retorno += meta.getFooter();

        //Retona Pagina
        return retorno;
    }
}