# Estrutura do Projeto

## Diretórios e Classes

### 1. **aplicacao/**

- **Classe Principal:**
  - `Main.java`: Classe principal que inicializa e executa o sistema.

- **Menu:**
  - Dentro da pasta `menu/` temos as seguintes classes e estrutura.

#### **Menu/**

- **Menu Admin:**
  - `MenuAdmin.java`: Exibe o menu de administração, com opções para gerenciar clientes, produtos e pedidos.
  - `MenuAdminAdiciona.java`: Adiciona novos itens como clientes, produtos e pedidos.
  - `MenuAdminConsulta.java`: Consulta dados dos clientes, produtos e pedidos.
  - `MenuAdminRemove.java`: Remove clientes, produtos e pedidos.

- **Menu Cadastro:**
  - `CadastroUsuario.java`: Classe responsável pelo cadastro de usuários no sistema.

- **Menu Cliente:**
  - `MenuAlteraCliente.java`: Permite alterar os dados do cliente.
  - `MenuCarrinhoDeCompra.java`: Exibe o carrinho de compras do cliente.
  - `MenuCliente.java`: Menu principal do cliente com opções para visualizar produtos, pedidos, etc.
  - `MenuPagamento.java`: Gerencia a parte de pagamento dos pedidos.
  - `MenuProduto.java`: Exibe os produtos disponíveis para o cliente.

- **Menu Login:**
  - `MenuLogin.java`: Gerencia o login do usuário no sistema.

- **Util:**
  - `CalculadoraDeValoresPedido.java`: Calcula os valores dos pedidos, levando em consideração os descontos e produtos.
  - `FormatadorExibicao.java`: Formata a exibição de informações como produtos, clientes, e pedidos para o usuário.

### 2. **dominio/**

#### 2.1 **Cliente:**

- **Fábrica:**
  - `FabricaClienteFactory.java`: Factory para a criação de clientes.
  - `FabricaClientePessoaFisica.java`: Factory para criação de clientes do tipo Pessoa Física.
  - `FabricaClientePessoaJuridica.java`: Factory para criação de clientes do tipo Pessoa Jurídica.

- **Interfaces:**
  - `AlteradorCliente.java`: Interface para alteração de dados do cliente.
  - `FabricaCliente.java`: Interface para criação de cliente.
  - `ValidadorCliente.java`: Interface para validação de dados do cliente.

- **Serviço:**
  - `AlteraCliente.java`: Serviço para alterar os dados de um cliente.
  - `ServicoCliente.java`: Serviço principal de clientes, realizando operações de cadastro e manipulação.
  - `ValidaCliente.java`: Serviço responsável pela validação dos dados do cliente.

- **Util:**
  - `FormataDocumento.java`: Utilitário para formatação de documentos (ex: CPF/CNPJ).
  - `SelecionaTipoCliente.java`: Utilitário para determinar o tipo de cliente (Pessoa Física ou Pessoa Jurídica).
  - `Cliente.java`: Representa a entidade cliente.
  - `ClientePessoaFisica.java`: Representa a entidade Cliente do tipo Pessoa Física.
  - `ClientePessoaJuridica.java`: Representa a entidade Cliente do tipo Pessoa Jurídica.
  
- **Enum:**
  - `TipoCliente.java`: Enum que define os tipos de cliente (Pessoa Física, Pessoa Jurídica).

#### 2.2 **Desconto:**

- **Desconto:**
  - `DescontoPedido.java`: Desconto aplicado no pedido.
  - `DescontoProduto.java`: Desconto aplicado em produtos.

- **Factory:**
  - `DescontoPedidoFactory.java`: Fábrica para criar descontos aplicados no pedido.
  - `DescontoProdutoFactory.java`: Fábrica para criar descontos aplicados em produtos.

- **Pedido:**
  - `DescontoFixo.java`: Desconto fixo para pedidos.
  - `ServicoDesconto.java`: Serviço para calcular descontos no pedido e nos produtos.

#### 2.3 **Frete:**

- **Frete:**
  - `Frete.java`: Representa as informações de frete para o pedido.
  - `FreteFactory.java`: Fábrica para criação de frete.
  - `FreteGratis.java`: Representa um tipo de frete gratuito.

- **Serviço:**
  - `ServicoFrete.java`: Serviço para calcular o frete de acordo com o pedido.

#### 2.4 **Notificação:**

- **Notificação:**
  - `Notificador.java`: Classe responsável por enviar notificações.
  - `NotificadorEmail.java`: Notificador específico para enviar notificações por e-mail.

- **Serviço:**
  - `ServicoNotificador.java`: Serviço para gerenciar e enviar notificações.

#### 2.5 **Pagamento:**

- **Pagamento:**
  - `Pagamento.java`: Classe responsável pelo processo de pagamento.
  - `PagamentoPix.java`: Representa a forma de pagamento via Pix.

#### 2.6 **Pedido:**

- **Pedido:**
  - `Pedido.java`: Representa o pedido do cliente.

- **Interfaces:**
  - `PedidoModificacao.java`: Interface para a modificação de pedidos.
  - `ValidadorPedido.java`: Interface para validação de dados do pedido.

- **Serviço:**
  - `ServicoPedido.java`: Serviço responsável pelo gerenciamento dos pedidos.
  - `ValidaPedido.java`: Serviço responsável pela validação dos pedidos.
  - `ItemPedido.java`: Representa um item dentro de um pedido.
  - `PedidoPadrao.java`: Representação padrão de um pedido.

- **Enum:**
  - `PedidoStatus.java`: Enum que define os diferentes status de um pedido (ex: "aberto", "finalizado").

#### 2.7 **Produto:**

- **Produto:**
  - `Produto.java`: Representa o produto.
  
- **Interfaces:**
  - `AlteradorProduto.java`: Interface para alteração de dados do produto.
  - `ValidadorProduto.java`: Interface para validação de dados do produto.

- **Serviço:**
  - `AlteraProduto.java`: Serviço responsável pela alteração de produtos.
  - `ServicoProduto.java`: Serviço para gerenciar os produtos no sistema.

- **Enum:**
  - `TipoProduto.java`: Enum que define os tipos de produto (ex: Eletrônicos, Livros, Papelaria, Vestuário).

- **Produto Específico:**
  - `ProdutoEletronico.java`: Representa o produto do tipo eletrônico.
  - `ProdutoLivro.java`: Representa o produto do tipo livro.
  - `ProdutoPapelaria.java`: Representa o produto do tipo papelaria.
  - `ProdutoVestuario.java`: Representa o produto do tipo vestuário.

- **Gerador:**
  - `GeradorDeProdutos.java`: Classe para gerar produtos automaticamente.

#### 2.8 **Usuário:**

- **Fábrica:**
  - `FabricaUsuario.java`: Fábrica para criação de usuários.

- **Interfaces:**
  - `AlteradorUsuario.java`: Interface para alteração de dados do usuário.
  - `ValidadorUsuario.java`: Interface para validação dos dados do usuário.

- **Serviço:**
  - `AlteraUsuario.java`: Serviço para alterar os dados do usuário.
  - `ServicoUsuario.java`: Serviço responsável pela manipulação dos usuários.
  - `ValidaUsuario.java`: Serviço para validar os dados do usuário.

- **Enum:**
  - `TipoUsuario.java`: Enum que define os tipos de usuários (ex: Admin, Cliente).

- **Usuário:**
  - `Usuario.java`: Representa o usuário.
  - `UsuarioAdmin.java`: Representa o usuário do tipo Admin.
  - `UsuarioCliente.java`: Representa o usuário do tipo Cliente.

### 3. **infraestrutura/**

- **Configuracoes:**
  - `Configuracoes.java`: Classe responsável pelas configurações do banco de dados futuramente.

---

### 4. **repositorio/**

#### 4.1 **Cliente:**

- **Interfaces:**
  - `RepositorioCliente.java`: Interface para o repositório de clientes.

- **Compostas:**
  - `RepositorioCliente.java`: Implementação composta do repositório de clientes.

- **Específicas:**
  - `ClienteConsulta.java`: Repositório para consulta de clientes.
  - `ClienteManipulacao.java`: Repositório para manipulação dos dados dos clientes.

- **Memória:**
  - `RepositorioClienteMemoria.java`: Implementação do repositório de clientes em memória.

---

#### 4.2 **Pedido:**

- **Interfaces:**
  - `RepositorioPedido.java`: Interface para o repositório de pedidos.

- **Compostas:**
  - `RepositorioPedido.java`: Implementação composta do repositório de pedidos.

- **Específicas:**
  - `PedidoConsulta.java`: Repositório para consulta de pedidos.
  - `PedidoManipulacao.java`: Repositório para manipulação dos dados dos pedidos.

- **Memória:**
  - `RepositorioPedidoMemoria.java`: Implementação do repositório de pedidos em memória.

---

#### 4.3 **Produto:**

- **Interfaces:**
  - `RepositorioProduto.java`: Interface para o repositório de produtos.

- **Compostas:**
  - `RepositorioProduto.java`: Implementação composta do repositório de produtos.

- **Específicas:**
  - `ProdutoConsulta.java`: Repositório para consulta de produtos.
  - `ProdutoManipulacao.java`: Repositório para manipulação dos dados dos produtos.

- **Memória:**
  - `RepositorioProdutoMemoria.java`: Implementação do repositório de produtos em memória.

---

#### 4.4 **Usuário:**

- **Interfaces:**
  - `RepositorioUsuario.java`: Interface para o repositório de usuários.

- **Compostas:**
  - `RepositorioUsuario.java`: Implementação composta do repositório de usuários.

- **Específicas:**
  - `UsuarioConsulta.java`: Repositório para consulta de usuários.
  - `UsuarioManipulacao.java`: Repositório para manipulação dos dados dos usuários.

- **Memória:**
  - `RepositorioUsuarioMemoria.java`: Implementação do repositório de usuários em memória.

### 5. **teste/**

#### **Integração:**
- `TesteDesconto.java`: Testes de integração para a lógica de desconto.
- `TesteFrete.java`: Testes de integração para o cálculo de frete.
- `TestePedido.java`: Testes de integração para o processo de pedidos.
- `TesteProdutoCompleto.java`: Testes de integração abrangentes para a funcionalidade de produtos.

#### **Unitário:**
- `TesteCliente.java`: Testes unitários para a classe Cliente.
- `TesteProduto.java`: Testes unitários para a classe Produto.

---

### 6. **util/**

- Não utilizada: Este diretório não contém arquivos ou funcionalidades no momento.
