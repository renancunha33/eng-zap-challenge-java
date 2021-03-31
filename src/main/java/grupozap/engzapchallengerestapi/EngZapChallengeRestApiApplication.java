package grupozap.engzapchallengerestapi;
/*
 *
 *  Classe Principal que inicia o servidor
 *
 */
import grupozap.engzapchallengerestapi.config.SwaggerConfig;
import grupozap.engzapchallengerestapi.util.ListarRegistros;
import grupozap.engzapchallengerestapi.model.Contrato;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EngZapChallengeRestApiApplication {
	//Variável Global de objeto
	public static List<Contrato> listaCache;

	//Get para pegar valores de ListaCache
	public static List<Contrato> getListaCache() {
		return listaCache;
	}

	//Set para insetir valores em ListaCache
	public static void setListaCache(List<Contrato> listaCache) {
		EngZapChallengeRestApiApplication.listaCache = listaCache;
	}

	public static void main(String[] args) {

		//Run SpringApplication
		SpringApplication.run(EngZapChallengeRestApiApplication.class, args);
		System.out.println("Carregando arquivo source-2.Json ...");

		//carrega Json em memória
		setListaCache(ListarRegistros.ListarRegistros());
		if(getListaCache()!= null) System.out.print("Cache carregado!");
	}

}
