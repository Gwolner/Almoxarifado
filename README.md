# Almoxarifado

> Projeto desenvolvido conforme instrunções em aula EaD de Web II do IFPE.

O servlet é uma classe Java normal que herda de HttpServlet. Sendo o Java uma tecnologia multiplataforma, ou seja, executa em vários lugares, podemos dizer que o servlet é a tecnologia usada por Java para web.

É o servlet é utilizado para comunicação **http** com o Java. O HttpServlet não está implementado no Java, quem o implementa é o servidor. Se analisarmos o HttpServlet, veremos que ele é uma classe abstrata que herda de GenericServlet e este implementa uma interface Servlet, que é implementada no servidor (GlassFish, Tomcat ou outros).

A vantagem do servlet: ele tem a mplementação de concorrencia, ou seja, se duas pessoas acessarem ao mesmo tempo, o servidor dará conta disso embora o serviço seja rapido, a não ser uma consulta pesada no BD, mas o servlet recebe a requisição, trata e devolve  resposta.

Geralmente essa respsota é HTML ou um texto e não JSP. Embora vejamos o JSP como uma página HTML, o que ocorre é que o JSP é convertido para servlet, que será o que o servidor irá ler.



## Playlist das aulas

