package grupozap.engzapchallengerestapi.controller;
/*
 *
 *  Classe Controller traz contratos de VivaReal
 *
 */
import grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication;
import grupozap.engzapchallengerestapi.model.Contrato;
import grupozap.engzapchallengerestapi.util.BoundinBox;
import grupozap.engzapchallengerestapi.util.PaginarJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST - Grupo ZAP")
@CrossOrigin(origins = "*")
public class VivaRealController {
    //variáveis e Objetos
    public List<Contrato> listaVivaReal; //Recebe Lista com todos os registos
    public List<Contrato> jsonList; //Recebe Lista com registros filtrados
    public float vlminimorent = 4000; //Vlr Minimo aluguel
    public float vlminimosale = 700000; //Vlr Minimo SALE
    public float multiplicadoraluguel = (float) 0.3; //multiplicador para pegar 30% do aluguel
    public float multiplicador = (float) 1.5; //Multiplicador que incremntea em 50% valor para estar na lista de VivaReal
    PaginarJson pg = new PaginarJson(); //Objeto Paginar Json
    BoundinBox bb = new BoundinBox(); //objeto com as variáveis de Bouding box

    //Mapping do Controller
    @GetMapping(path = "/vivareal")
    @ApiOperation(value = "Retorna a Pagina com a quantidade desejada de registros do Total de registros que pertencem ao Grupo ZAP")
    public String VivaRealController(@RequestParam int page, @RequestParam int size) throws Exception {

        //lista recebe todos os registros JSON
        listaVivaReal = new EngZapChallengeRestApiApplication().getListaCache();
        //Instancia Arry
        jsonList = new ArrayList<Contrato>();

        //Laço de repetição para avaliar registros
        for (int i = 0; i < listaVivaReal.toArray().length; i++) {

            //valida se lat e lon são != 0
            if (listaVivaReal.get(i).getAddress().getGeoLocation().getLocation().getLon() != 0
                    && listaVivaReal.get(i).getAddress().getGeoLocation().getLocation().getLat() != 0
            ) {
                //Valida business type
                switch (listaVivaReal.get(i).getPricingInfos().getBusinessType()) {
                    case "RENTAL":

                        //regra antiga - valor do aluguel deve ser até 4000
                        if (Float.valueOf(listaVivaReal.get(i).getPricingInfos().getPrice()) <= vlminimorent) {

                            // try/catch somente para validar condominios mensais com valor numerico
                            try {
                                float vlr = Float.valueOf(listaVivaReal.get(i).getPricingInfos().getMonthlyCondoFee());

                                //valida se valor do condomínio mensal é menor que 30% do aluguel
                                if (vlr < Float.valueOf(listaVivaReal.get(i).getPricingInfos().getPrice()) * multiplicadoraluguel) {

                                    //valida se está dentro do Bouding box
                                    if (listaVivaReal.get(i).getAddress().getGeoLocation().getLocation().getLon() >= bb.getMinlon()
                                            && listaVivaReal.get(i).getAddress().getGeoLocation().getLocation().getLon() <= bb.getMaxlon()
                                            && listaVivaReal.get(i).getAddress().getGeoLocation().getLocation().getLat() >= bb.getMinlat()
                                            && listaVivaReal.get(i).getAddress().getGeoLocation().getLocation().getLat() <= bb.getMaxlat()) {

                                        //validador com valor minimo do aluguel elevado em 50%
                                        if (Float.valueOf(listaVivaReal.get(i).getPricingInfos().getPrice()) >= vlminimorent * multiplicador)
                                            //incrementa variavel com mais um registro
                                            jsonList.add(listaVivaReal.get(i));
                                    }
                                }
                            } catch (Exception C) {
                                // Do nothing
                            }
                        }
                        break;
                    case "SALE":
                        //validação antiga - valor de vendo até 700000
                        if (Float.valueOf(listaVivaReal.get(i).getPricingInfos().getPrice()) <= vlminimosale)

                            //incrementa variavel com mais um registro
                            jsonList.add(listaVivaReal.get(i));
                        break;
                    default:
                        break;
                }
            }
        }
        // Retorna Pagina com qtd de registros desejada
        return pg.getPageContrato(jsonList, page, size, jsonList.size());
    }
}
