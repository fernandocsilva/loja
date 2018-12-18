#Brasilprev - Loja

Esta é uma API que representa uma loja genérica, ou seja, é uma estrutura que serve de base para uma loja online que trabalhe com produtos, clientes e seus respectivos pedidos.

A aplicação está rodando na AWS e sua documentação pode ser acessada através do link:
<http://ec2-18-231-176-237.sa-east-1.compute.amazonaws.com:8080/swagger-ui.html>

A documentação pode ser vista pelo link acima, porém os testes não poderão ser realizados pelo swagger, pois a aplicação possui atenticação por Json Web Token, utilizando Spring Security.

Para testar a API, é necessário realizar uma requisição para um endpoint de login, passando um Json com usuário e senha. Segue um exemplo:
> http://ec2-18-231-176-237.sa-east-1.compute.amazonaws.com:8080/login
>
> {"username":"admin", "password":"123456"}

O Token de autenticação estará na aba Headers.

Para acessar os demais métodos, basta incluir o token na autenticação do tipo **Bearer**. Vá para a aba _Authorization_ e informe o tipo (TYPE) **Bearer Token**. Ao lado, no campo _Token_, insira o token gerado pela requisição do login.
