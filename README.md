# Almoxarifado

> Projeto desenvolvido conforme instruções em aula EaD de Web II do IFPE.

O servlet é uma classe Java normal que herda de HttpServlet. Sendo o Java uma tecnologia multiplataforma, ou seja, executa em vários lugares, podemos dizer que o servlet é a tecnologia usada por Java para web.

É o servlet é utilizado para comunicação **http** com o Java. O HttpServlet não está implementado no Java, quem o implementa é o servidor. Se analisarmos o HttpServlet, veremos que ele é uma classe abstrata que herda de GenericServlet e este implementa uma interface Servlet, que é implementada no servidor (GlassFish, Tomcat ou outros).

A vantagem do servlet: ele tem a implementação de concorrência, ou seja, se duas pessoas acessarem ao mesmo tempo, o servidor dará conta disso embora o serviço seja rápido, a não ser uma consulta pesada no BD, mas o servlet recebe a requisição, trata e devolve  resposta.

Geralmente essa resposta é HTML ou um texto e não JSP. Embora vejamos o JSP como uma página HTML, o que ocorre é que o JSP é convertido para servlet, que será o que o servidor irá ler.

Pasta WEB-INF e META-INF são protegidas, ou seja, qualquer arquivo que se dispor ali dentro, não será acessível para nenhuma parte da aplicação via chamada direta (redirecionamento, encaminhamento, view, etc).

O HttpServlet é a implementação do Servlet para Http. é  um protocolo de camada de aplicação, o que significa que é um protocolo cliente-servidor, onde o servidor detem todo conteúdo e o cliente faz requisição a esse conteúdo, tanto requisições pedindo quanto enviando informações para que o servidor trate.

Inicialmente o servlet é usado so pra tratar requisição Get e Post, porém o http possui outras como o Put e Delete, que hoje tem mais sentido que antigamente (o post pra fazer cadastro e o get pra recuperar informação), porem com os novos métodos de desenvolvimento, usa-se todas as palavras do http. Tanto put quanto o delete.

O método proccessRequest é usado para atender a qualquer tipo de requisição que apareça, tanto get quanto post, mas não faz mais sentido nos dias atuais, pois dessa forma, so get e post, era criado um servlet pra tudo (servlet de cadastro, servlet de alteração, servlet de deleção) e isto não faz sentido, pois deve-se usar as palavras do http.


## Java Server Pages - JSP

Página web que permite a inserção de código Java, sendo constituida de um conjunto de Diretivas e Scriptings.

* **Diretivas** são usadas para configurar a página, incluir recursos externos ou referenciar bibliotecas de tags;

  * Page: Configura a página.
```jsp
<%@page atributo="valor"%>
```

  * Include: Adiciona conteudo externo à página.
```jsp
<%@include file="pagina"%>
```

  * taglib
```jsp
 //ADICIONAR
```

* **Scriptings** é usado para escrever código java.

  * Declaração: declara e/ou inicializa variável e método na página.
```jsp
<%! int a = 0 &>
```

  * Scriplet: realiza programação na página. Tambem inicializa e declara variável.
```jsp
<% if(a>10){ e = 2} %>
```

  * Expressão: usada pra imprimir no HTML o valro de um cálculo ou valores de variáveis.
```jsp
<% a+20 %>
```

  * Comentário: inseri um comentário no código, porém, diferente do HTML, não é enviado para o usuário.
```jsp
<%!-- texto --%>
```

### Objetos implícitos

O JSP possui objetos implícitos (que não precisam de uma declaração formal), podendo ser usado livremente.
(request, response, session, page, out, exception, application, pageContext)



## Linhas de códigos usuais

Obtendo parâmetros da requisição <br>
`String param = request.getParameter("nome_parametro");`

Sessão: existe uma sessão por navegador e não por usuario.
`HttpSession session = request.getSession(); //Retorna a sessão que existe. Se não existir, cria uma nova.
HttpSession session = request.getSession(false); //Retorna a sessão que existe, aso não exista laça uma excessão.

session.isNew(); //Verifica se a sessão é nova.

session.setAttribute("chave","valor");

sessiom.getAttribute("chave");
`

# Redirecionamento

`response.sendRedirect("pagina.jsp");`




## Playlist das aulas

