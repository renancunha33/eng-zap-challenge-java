# eng-zap-challenge-java
## Opção B do Code Challenge do Grupo ZAP

API Rest Code Challenge ZAP:

Esta API foi possível através das sequintes ferramentas: <br/>

- SpringBoot 2.4.4 <br/>
- IntelliJ 2020.3.3 <br/>
- Postman 8.0.10 <br/>

Necessário para Testes e Deploy:<br/>

- Apache Tomcat 9.0.44<br/>
- JDK 16<br/>

## HOW TO USE:
<br/>
API se encontra no Seguinte diretório:

> http://HOSTNAME/API
<br>
API TREE:

- /API <br/>
  - /zap <br/>
  - /vivareal <br/>
<br/>
Após entrar em um dos endereçoes é necessário passar via QueryURL os sequites parâmetros:
```
int page;
int size; 
```
_Exemplo:_
<br/>

>http://localhost:8080/api/vivareal?page=105&size=5 //Retorna página 10 com Size == 5 elementos

<br/><br/>
##TESTS:
<br/>
No projeto existem testes unitários na pasta /test/java
<br/>
Existem testes para as classes nos seguinte packages:
<br/>

- API (Main Calss)  
- Controller 
- DAO  
- Util  

