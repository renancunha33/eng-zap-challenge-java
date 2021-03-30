# eng-zap-challenge-java
Opção B do Code Challenge do Grupo ZAP

API Rest Code Challenge ZAP:

Esta API foi possível através das sequintes ferramentas:

SpringBoot 2.4.4
IntelliJ 2020.3.3
Postman 8.0.10

Necessário para Testes e Deploy:

Apache Tomcat 9.0.44
JDK 16

HOW TO USE:

API se encontra no Seguinte diretório:

http://HOSTNAME/API

API TREE:

+ /API <br/>
| <br/>
+ ----- /zap <br/>
| <br/>
+ ----- /vivareal <br/>

Após entrar em um dos endereçoes é necessário passar via QueryURL os sequites parâmetros:

int page; <br/>
int size; <br/>

Exemplo:

http://localhost:8080/api/vivareal?page=105&size=5

TESTS:

No projeto existem testes unitários na pasta /test/java

Existem testes para as classes nos seguinte packages:

/API (Main Calss) <br/>
/Controller <br/>
/DAO <br/>
/Util <br/>

