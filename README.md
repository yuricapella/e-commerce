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

## Estrutura do Projeto
- **aplicacao.menu**  
  - `MenuAdmin`, `MenuLogin`, `MenuPrincipal`, `MenuCadastro`  
  - Submenus: `menuadmin` (incluindo `MenuAdminAdiciona`, `MenuAdminRemove`, `MenuAdminConsulta`), `menucadastro`, `menulogin`, `menucliente` (incluindo `MenuCliente`, `MenuProduto`, `MenuCarrinhoDeCompra`, `MenuPagamento`, `MenuAlteraCliente`)
  
- **aplicacao.menu.util**  
  - `FormatadorExibicao`: Métodos estáticos para exibir pedidos, produtos, clientes e usuários.
  - `CalculadoraDeValoresPedido`: Funções para calcular descontos, frete e valores finais.
  
- **Domínio e Serviços**  
  - Classes e interfaces para Clientes, Produtos, Pedidos, Usuários e seus respectivos serviços (ex.: `ServicoCliente`, `ServicoProduto`, `ServicoPedido`, `ServicoUsuario`, `ServicoDesconto`).
  - Validações via classes como `ValidaCliente`, `ValidaUsuario` e `ValidaPedido`.
  
- **Repositórios**  
  - Implementações em memória para persistência de dados (ex.: `RepositorioClienteMemoria`, `RepositorioProdutoMemoria`, `RepositorioPedidoMemoria`, `RepositorioUsuarioMemoria`).

## Tecnologias
- **Java** – Implementação em linguagem Java, utilizando conceitos de OOP e princípios SOLID.
- **Scanner** – Para interação via console.
- **Design Patterns** – Uso de Factory, Strategy e Repository patterns para modularidade e escalabilidade.

## Como Rodar
1. **Pré-requisitos:**  
   - JDK 15 ou superior instalado.

2. **Clone o Repositório:**
   ```bash
   git clone https://github.com/yuricapella/e-commerce.git

3. **Compile e Execute:**
   - Compile o projeto utilizando sua IDE preferida ou via linha de comando:
     ```bash
     javac -d bin src/*.java
     ```
   - Execute o projeto a partir da classe principal `Main`:
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

# Estrutura do Projeto

## Visão Geral

A estrutura do projeto foi organizada, com separação de responsabilidades em camadas como **aplicação**, **domínio**, **infraestrutura**, **repositorio**, **teste** e **util**.

## Acesse a Estrutura Completa

Para ver a estrutura detalhada do projeto, clique no link abaixo:

[Veja a Estrutura do Projeto](ESTRUTURA.md)

Este arquivo contém a divisão completa de pastas e arquivos, incluindo a descrição de cada componente e sua função no sistema.

