# eng-zap-challenge-java
## Opção B do Code Challenge do Grupo ZAP

API Rest Code Challenge ZAP:

Esta API foi possível através das sequintes ferramentas: <br>

- SpringBoot 2.4.4 
- IntelliJ 2020.3.3 
- Postman 8.0.10
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- Apache Tomcat 9.0.44
- JDK 16

## HOW TO USE:

- Iniciar aplicação através da classe principal:
```java
public static void main(String[] args) {

		//Run SpringApplication
		SpringApplication.run(EngZapChallengeRestApiApplication.class, args);
		System.out.println("Carregando arquivo source-2.Json ...");

		//carrega Json em memória
		setListaCache(ListarRegistros.ListarRegistros());
		if(getListaCache()!= null) System.out.print("Cache carregado!");
	}
```
- Após inicar aplicação, aguardar a seguinte mensagem de carregamento do arquivo Json em memória:
```
Carregando arquivo source-2.Json ...
Conectado - status: 200
cache carregado
```
<br>
- API se encontra no Seguinte diretório:

> http://HOSTNAME/api
<br>
API TREE:

- /api
  - /zap 
  - /vivareal 
<br>
Após entrar em um dos endereçoes é necessário passar via QueryURL os sequites parâmetros:<br>

```
int page;
int size; 
```
<br>
Exemplo:
<br>

>http://localhost:8080/api/vivareal?page=105&size=5 //Retorna página 10 com Size == 5 elementos em JSON

<br><br>
## TESTS:
<br>
No projeto existem testes unitários na pasta /test/java
<br>
Existem testes para as classes nos seguinte packages:
<br>

- API (Main Calss)  
- Controller 
- DAO  
- Util  
<br>
Caso queira testar Através das requisições na URL, pode utilizar o navegador ou o Postman com o que foi passado no "How to use":
https://www.postman.com/downloads/

Também pode ser testado através do Swagger UI.


## Melhorias Futuras:
- Navegação entre paginas na API
- Criação de Docker Container com a API
- Implementação de logs detalhadas
