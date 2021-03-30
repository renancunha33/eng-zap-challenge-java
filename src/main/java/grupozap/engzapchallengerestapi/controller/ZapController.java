package grupozap.engzapchallengerestapi.controller;
/*
 *
 *  Classe Controller traz contratos de Zap
 *
 */
import grupozap.engzapchallengerestapi.EngZapChallengeRestApiApplication;
import grupozap.engzapchallengerestapi.model.Contrato;
import grupozap.engzapchallengerestapi.util.BoundinBox;
import grupozap.engzapchallengerestapi.util.PaginarJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ZapController {
    //variáveis e Objetos
    public List<Contrato> listaZap; //Recebe Lista com todos os registos
    public List<Contrato> jsonList; //Recebe Lista com registros filtrados
    public float vlminimorent = 3500; //Vlr Minimo aluguel
    public float vlmetroquad = 3500; //Vlr Metro quadrado
    public float vlminimosale = 600000; //Vlr Minimo SALE
    public float multiplicador = (float) 0.9; //Multiplicador que diminui em 10% valor para estar na lista de Grupo ZAP
    PaginarJson pg = new PaginarJson(); //Objeto Paginar Json
    BoundinBox bb = new BoundinBox(); //objeto com as variáveis de Bouding box


    //Mapping do Controller
    @GetMapping(path = "/api/zap")
    public String ZapController(@RequestParam int page, @RequestParam int size) throws Exception {

        //lista recebe todos os registros JSON
        listaZap = new EngZapChallengeRestApiApplication().getListaCache();
        //Instancia Arry
        jsonList = new ArrayList<Contrato>();

        //Laço de repetição para avaliar registros
        for (int i = 0; i < listaZap.toArray().length; i++) {

            //valida se lat e lon são maiores que 0
            if (listaZap.get(i).getAddress().getGeoLocation().getLocation().getLon() != 0
                    && listaZap.get(i).getAddress().getGeoLocation().getLocation().getLat() != 0

                    //valida preço por metro quadrado é maior que 3500
                    && (Float.valueOf(listaZap.get(i).getPricingInfos().getPrice()) / listaZap.get(i).getUsableAreas() > vlmetroquad)) {

                //valida se está dentro do Bouding box
                if (listaZap.get(i).getAddress().getGeoLocation().getLocation().getLon() >= bb.getMinlon()
                        && listaZap.get(i).getAddress().getGeoLocation().getLocation().getLon() <= bb.getMaxlon()
                        && listaZap.get(i).getAddress().getGeoLocation().getLocation().getLat() >= bb.getMinlat()
                        && listaZap.get(i).getAddress().getGeoLocation().getLocation().getLat() <= bb.getMaxlat()) {
                    switch (listaZap.get(i).getPricingInfos().getBusinessType()) {

                        //caso seja aluguel com desconto de 10% por estar no bounding box
                        case "RENTAL":
                            if (Float.valueOf(listaZap.get(i).getPricingInfos().getPrice()) >= vlminimorent * multiplicador)
                                //incrementa variavel com mais um registro
                                jsonList.add(listaZap.get(i));
                            break;

                        //caso seja aluguelvenda com desconto de 10% por estar no bounding box
                        case "SALE":
                            if (Float.valueOf(listaZap.get(i).getPricingInfos().getPrice()) >= vlminimosale * multiplicador)
                                //incrementa variavel com mais um registro
                                jsonList.add(listaZap.get(i));
                            break;
                        default:
                            break;
                    }
                } else {
                    switch (listaZap.get(i).getPricingInfos().getBusinessType()) {

                        //regra antiga - caso seja aluguel >= 3500
                        case "RENTAL":
                            if (Float.valueOf(listaZap.get(i).getPricingInfos().getPrice()) >= vlminimorent)
                                //incrementa variavel com mais um registro
                                jsonList.add(listaZap.get(i));
                            break;

                        //regra antiga - caso seja venda >=60000
                        case "SALE":
                            if (Float.valueOf(listaZap.get(i).getPricingInfos().getPrice()) >= vlminimosale)
                                //incrementa variavel com mais um registro
                                jsonList.add(listaZap.get(i));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        // Retorna Pagina com qtd de registros desejada
        return pg.getPageContrato(jsonList, page, size, jsonList.size());
    }
}
