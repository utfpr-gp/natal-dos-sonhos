# natal-dos-sonhos

É um sistema para auxiliar na arrecadação de recursos financeiros a fim de proporcionar ações beneficentes de Natal organizadas pelo curso de Tecnologia de Sistemas para Internet (TSI) da UTFPR de Guarapuava.

O sistema foi inicialmente desenvolvido pela turma do segundo semestre de 2016 da disciplina de Web IV do curso de TSI.

## Principais Funcionalidades
+ Cadastro de escolas e de cartas de natal elaboradas pelas crianças de tais escolas.
+ Apresentação das cartas de natal aos usuários.
+ Apresentação dos detalhes de cada carta, incluindo o total arrecadado e mensagens deixadas pelos doadores.
+ Possibilidade de doação de qualquer quantia a uma carta, de forma virtual via cartão de crédito ou física diretamente a um organizador da ação de natal.
+ Monitoramento da percentagem de arrecadação de cada carta.
+ Apresentação de fotos da entrega do presente à criança da carta contemplada.

## Tecnologias
+ JSF
+ JPA (Hibernate)
+ Primefaces 
+ Materialize

## Ferramentas
+ Netbeans
+ Tomcat
+ MySQL
+ Maven

## Manual de Execução
+ Clonar o repositório com  `git clone`
+ Entrar no diretório `src/mais/webapp/resources` via prompt de comando e instalar as dependências definidas no arquivo `package.json` via `npm`
  - Digite o comando `npm install`
  - Este comando vai criar o diretório `node_modules` com as dependências do Materialize e outros.
+ Entrar na raiz do projeto via prompt de comando e instalar as dependência definidas no arquivo `pom.xml` do Maven
  - Digite o comando `mvn clean install`
+ Criar um novo banco de dados no MySQL com o nome `natal_dos_sonhos`
+ Editar o arquivo `src/main/resources/META-INF/persistence.xml` com as configurações de acesso ao banco de dados `natal_dos_sonhos`
 - Alterar a propriedade `javax.persistence.jdbc.user` para o usuário correspondente ao MySQL
 - Alterar a propriedade `javax.persistence.jdbc.password` para a senha correspondente ao MySQL
+ Executar o projeto.

## Versão Corrente
0.0.1 - Release de 07/12/2016






