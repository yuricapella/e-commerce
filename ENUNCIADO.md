# Enunciado do Projeto

## Ada Commerce - E-Commerce

A Ada Tech pretende realizar a venda de produtos através de um E-Commerce e, para isso, nos contratou com a finalidade de desenvolvermos todo o fluxo necessário. Nesse E-Commerce temos algumas necessidades que serão descritas abaixo.

### Funcionalidades

1. **Cadastro de Clientes**
   - Cadastrar, listar e atualizar os clientes na base de dados.
   - Não é necessário excluir clientes, pois esses devem permanecer na base como histórico.

2. **Cadastro de Produtos**
   - Cadastrar, listar e atualizar os produtos na base de dados.
   - Não é necessário excluir produtos, pois esses devem permanecer na base como histórico.

3. **Gestão de Vendas**
   - Criar uma venda para um cliente.
   - Durante a venda, deve ser possível:
     - Adicionar item (produto) com quantidade e preço.
     - Remover item (produto).
     - Alterar a quantidade do item (produto).
     - Realizar o pagamento e a entrega.

### Regras Importantes

- Todo cliente cadastrado precisa ter um documento de identificação.
- Um pedido sempre deve ter a data em que foi criado.
- Um pedido sempre deve iniciar com o status "aberto".
- Pedidos com status "aberto" podem receber itens (produto), alterar a quantidade e remover itens.
- Os produtos adicionados ao pedido devem ter um valor de venda informado, que pode ser diferente do valor do produto.
- Para finalizar o pedido, ele deve ter ao menos um item e o valor deve ser maior que zero. O status do pagamento deve ser alterado para "Aguardando pagamento", e o cliente deve ser notificado via e-mail.
- A ação de pagar deve ocorrer apenas sobre pedidos com o status "Aguardando pagamento". Após o pagamento ser realizado com sucesso, o status do pagamento deve ser alterado para "Pago", e o cliente deve ser notificado.
- Após o pagamento, o pedido pode ser entregue ao cliente e o status deve ser alterado para "Finalizado". O cliente também deve ser notificado sobre a entrega.

### Dicas para o Desenvolvimento

- Lembre-se de utilizar os conceitos aprendidos em sala de aula, como os princípios de orientação a objetos e SOLID.
- A princípio, é possível trabalhar com uma base de dados em memória para simplificar o exercício, mas, se preferir, pode implementar a persistência dos dados em arquivos. Este é um item bônus e não obrigatório.
