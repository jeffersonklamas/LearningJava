## Projeto Curso Capgemini

### Definição de um projeto básico:

* Aplicativo para gerenciamento de uma lista de projetos e tarefas.
* Nome:
  * ToDo App
* Descrição:
  * Aplicação para o gerenciamento de projetos e tarefas envolvidas nos projetos.
* Objetivos:
  * Resolver a questão de organização de tarefas de um ou vários projetos.

### Requisitos do Projeto

#### Entidades

* Projeto;
  * Atributos
    * Nome
    * Descrição
    * Data de Criação
    * Data de Atualização
* Tarefa.
  * Atributos
    * Nome
    * Descrição
    * Status
      * Concluída
      * Não Concluída
    * Observações
    * Prazo
    * Data de Criação
    * Data de Atualização

#### Requisitos

* Permitir criar o projeto;
* Permitir alterar o projeto;
* Permitir excluir o projeto;
* Permitir criar a tarefa;
* Permitir alterar a tarefa;
* Permitir excluir a tarefa;

### Regras de negócio

* Não irá conter um sistema de login;
* Não haverá o conceito de usuário;
* Toda tarefa deve pertencer a um projeto.

### Tecnologias utilizadas

* Java
* Gradle
* MySql

### Sequência para desevolvimento:

* Criação do banco de dados - OK
* Criação das classes de modelo - OK
* Criação da conexão com o banco de dados - Ok
* Criação das classes de controle (Acesso aos dados do banco de dados) - OK
* Criação da interface gráfica - OK
  * Criação da tela principal - OK
    * Criação do CellRederer Prazo
    * Criação do CellRederer Editar e Deletar
  * Criação da tela de Cadastro de Projeto - OK 
  * Criação da tela de Cadastro de Tarefa - OK
* Implementação dos eventos
  * Validações
* Ajustes finais
* Teste da aplicação

