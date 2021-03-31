package grupozap.engzapchallengerestapi.config;
/*
*
* Swagger da API
*
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket ContratoApi() {
        Docket dock = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("grupozap.engzapchallengerestapi"))
                .paths(regex("/api.*"))
                .build()
                .pathMapping("/")
                .apiInfo(metaInfo());
        System.out.println(dock.genericModelSubstitutes().toString());
        return dock;

    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API REST - Grupo ZAP",
                "API REST de consulta e retorno da lista de contratos de imoveis do Grupo ZAP + Viva Real",
                "1.0",
                null,
                new Contact("Renan Cunha", "https://renancunha33.github.io",
                        "renan.cunha20@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
