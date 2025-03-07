# Ada Commerce - E-Commerce

## Descrição
Este projeto foi desenvolvido para atender a Ada Tech no desenvolvimento de um sistema de e-commerce, como parte da disciplina **Programação Orientada a Objetos II** do programa **Desenvolva+** da Ada & Mercado Livre. O sistema abrange todo o fluxo necessário para a venda de produtos online, desde o cadastro e atualização de clientes e produtos até a criação e finalização de pedidos, com as regras de negócio definidas pelo cliente.

## Funcionalidades
- **Clientes:**
  - Cadastro, listagem e atualização (sem exclusão, mantendo histórico).
  - Validação de dados (nome, documento e email) via interfaces e classes de validação (ex.: `ValidaCliente`).
  - Associação de clientes aos usuários, garantindo que o login só seja efetuado para usuários ativos.

- **Produtos:**
  - Cadastro, listagem e atualização dos produtos.
  - Diferenciação dos tipos de produto (Eletrônico, Livro, Vestuário, Papelaria) e validação de informações.
  - Geração automatizada de listas de produtos utilizando o `GeradorDeProdutos`.

- **Pedidos:**
  - Criação de pedidos para clientes, iniciando sempre com o status **ABERTO**.
  - Adição de itens (produto, quantidade e valor de venda), remoção e alteração de quantidade através de métodos como `adicionarItem()`, `removerItem()` e `alterarQuantidadeItem()`.
  - Regras de negócio para finalização do pedido: deve ter pelo menos um item, valor maior que zero, mudança de status para **AGUARDANDO_PAGAMENTO**, e notificações por e-mail.
  - Processamento do pagamento somente quando o pedido estiver em status **AGUARDANDO_PAGAMENTO** e alteração para **PAGO** após o sucesso, com envio de notificação.
  - Entrega do pedido e alteração final do status para **FINALIZADO**, também com notificação.

- **Usuários:**
  - Cadastro e autenticação de usuários com verificação de login/senha e status ativo.
  - Tipos de usuários: `USUARIO` (associado a um cliente) e `ADMINISTRADOR`.

- **Interface e Exibição:**
  - Menus interativos para Administrador e Cliente, com navegação modular:
    - **MenuAdmin**: Gerencia operações de adição, remoção e consulta de dados (clientes, produtos, pedidos e usuários).
    - **MenuCliente**: Permite ao cliente acessar produtos, carrinho, pagamento e alteração de dados.
    - **MenuLogin** e **MenuCadastro**: Gerenciam o fluxo de autenticação e cadastro.
  - A classe `FormatadorExibicao` é utilizada para exibir dados (pedidos, produtos, clientes e usuários) de forma padronizada e organizada, garantindo uma interface limpa e intuitiva.
  - Cálculos centralizados em `CalculadoraDeValoresPedido` para determinar descontos, frete e o valor final do pedido.

## Tecnologias
- **Java** – Implementação em linguagem Java, utilizando conceitos de OOP e princípios SOLID.
- **Scanner** – Para interação via console.
- **Design Patterns** – Uso de Factory, Strategy e Repository patterns para modularidade e escalabilidade.

## Como Rodar

### Pré-requisitos:
- **JDK 15 ou superior** instalado.

### Passos:

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/yuricapella/e-commerce.git
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd e-commerce
   ```

3. **Compile e Execute:**
   - Compile o projeto utilizando sua IDE ou via linha de comando:
     ```bash
     javac -d bin src/*.java
     ```
   - Execute a classe principal:
     ```bash
     java -cp bin Main
     ```
     
4. **Interaja com o Sistema:**
   - O programa exibirá um menu interativo, permitindo que o usuário:
     - Faça login ou cadastre-se.
     - Navegue entre os menus de administração e cliente.
     - Visualize, adicione, altere e remova clientes, produtos e pedidos.
     - Realize o processamento do pagamento e a finalização do pedido, com notificações por e-mail.

5. **Observações:**
   - O sistema utiliza persistência em memória, podendo ser expandido para persistência em arquivos (item bônus).
   - Todas as funcionalidades do fluxo de e-commerce, como cadastro, atualização, pagamento e entrega, foram implementadas seguindo os princípios de orientação a objetos e SOLID.

---

## Resumo do Projeto

Este repositório contém um sistema completo para um e-commerce, desenvolvido para gerenciar o fluxo de vendas de uma plataforma de comércio eletrônico. O projeto abrange várias funcionalidades e menus, tanto para administração quanto para clientes, incluindo:

- **Cadastro de Clientes**: Gerencia o cadastro e atualização de informações dos clientes, sem exclusão, mantendo os registros históricos.
- **Cadastro de Produtos**: Permite o cadastro e atualização de produtos, com o controle de estoque e de preços.
- **Pedidos**: Gerencia os pedidos, permitindo a adição, remoção e alteração de itens, além de possibilitar o processo de pagamento e entrega.
- **Notificação**: O sistema envia notificações por e-mail aos clientes quando o status do pedido muda (pagamento e entrega).
- **Menu de Administração**: Para gerenciar clientes, produtos e pedidos de forma prática.
- **Menu do Cliente**: Permite ao cliente visualizar e gerenciar seus pedidos, visualizar produtos e realizar compras.

---

## Estrutura do Projeto

A estrutura do projeto foi organizada em camadas para garantir separação de responsabilidades:

- **aplicacao/**  
  - Contém os menus interativos (`MenuAdmin`, `MenuCadastro`, `MenuCliente`, `MenuLogin`, `MenuPrincipal`, etc.).

- **dominio/**  
  - Contém as entidades, serviços e regras de negócio para clientes, produtos, pedidos, usuários, descontos, frete, notificações e pagamentos.

- **infraestrutura/**  
  - Apenas um esboço

- **repositorio/**  
  - Contém as implementações dos repositórios (em memória) para clientes, produtos, pedidos e usuários.

- **teste/**  
  - Contém simulação de testes unitários e de integração do sistema.

- **util/**  
  - Apenas um esboço

Para ver a estrutura completa do projeto, confira o arquivo [ESTRUTURA.md](ESTRUTURA.md).

---

## Documentação Complementar
- [ENUNCIADO.md](ENUNCIADO.md) - Enunciado completo do projeto.
- [ATALHOS.md](ATALHOS.md) - Credenciais e atalhos de acesso pré-configurados.


