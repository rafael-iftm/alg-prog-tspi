# Projeto de Gerenciamento de Endereços

Este projeto em Java foi desenvolvido para gerenciar informações relacionadas a consultas médicas e endereços de pessoas. O sistema é composto por três classes principais: `Pessoa`, `Endereco`, e `Programa`.

## Participantes

- **Rafael Andrade Prado**
- **João Vitor Quintanilha**
- **Lucas José Arantes**

## Estrutura do Projeto

### Classes

1. **Pessoa:**
   - Representa uma pessoa, com atributos como nome, idade e endereço.
   - Permite a criação, edição, consulta e remoção de pessoas.

2. **Endereco:**
   - Representa um endereço, com atributos para rua, cidade e estado.
   - Utilizada pela classe `Pessoa` para armazenar informações de endereço.

3. **Programa:**
   - Classe principal que gerencia as interações com o usuário.
   - Oferece um menu com opções para cadastrar, editar, apagar, consultar e listar pessoas.
   - Possui métodos para manipular endereços e tipos de endereço.

### Funcionalidades Implementadas

1. **Cadastrar Nova Pessoa:**
   - Permite o usuário cadastrar uma nova pessoa, fornecendo nome, idade e informações de endereço.

2. **Editar Dados da Pessoa:**
   - Possibilita a edição dos dados de uma pessoa existente, incluindo nome, idade e endereço.

3. **Apagar Pessoa:**
   - Remove uma pessoa do sistema, requisitando o nome para identificação.

4. **Consultar Pessoa:**
   - Facilita a consulta de informações de uma pessoa, solicitando o nome como referência.

5. **Listar Todas as Pessoas:**
   - Exibe uma lista de todas as pessoas cadastradas, mostrando detalhes como nome, idade e endereço.

6. **Criar Novo Tipo de Endereço:**
   - Permite a criação de novos tipos de endereço, como residencial, comercial, etc.

7. **Listar Tipos de Endereço:**
   - Exibe todos os tipos de endereço cadastrados no sistema.

8. **Consultar Endereço de uma Pessoa:**
   - Facilita a consulta do endereço de uma pessoa, solicitando o nome como referência.

9. **Listar Todas as Pessoas com Seus Endereços:**
   - Exibe uma lista de todas as pessoas cadastradas, incluindo informações detalhadas sobre seus endereços.

10. **Sair:**
    - Encerra a execução do programa.

### Validações Implementadas

- **Validação de Dados:**
  - Garante que dados essenciais, como nome de pessoa, não sejam inseridos como vazios.
  - Realiza validações específicas para assegurar a integridade dos dados.

- **Tratamento de Exceções:**
  - Implementa tratamento de exceções para situações como entrada de dados inválidos, evitando a quebra do programa.

## Como Utilizar

1. **Execução:**
   - Compile e execute a classe `Programa` para iniciar o sistema.
   - Um menu será apresentado com opções numeradas para interação.

2. **Opções do Menu:**
   - Escolha a opção desejada inserindo o número correspondente.
   - Siga as instruções apresentadas para realizar as operações desejadas.

3. **Encerramento:**
   - Para encerrar o programa, selecione a opção de sair no menu.

Este projeto visa fornecer uma base para o gerenciamento de consultas e endereços, incorporando boas práticas de programação em Java e atendendo aos requisitos propostos.
