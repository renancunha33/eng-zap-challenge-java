package grupozap.engzapchallengerestapi.util;
/*
*
* Objeto com cabeçalho e rodapé para a inserção de metadados na pagina Json
*
 */
public class Metadados {
    //Atributos
    private String header;
    private String footer;

    // Cabeçalho
    public String getHeader(int page, int size, int total) {
        header = ("{\n" +
                "    pageNumber: "+page+",\n" +
                "    pageSize: "+size+",\n" +
                "    totalCount: "+total+",\n" +
                "    listings: [\n");
        return header;
    }

    //Rodapé
    public String getFooter() {
        footer = ("  ]\n" +
                "  }");
        return footer;
    }
}
