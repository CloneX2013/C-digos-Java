# Sistema de Gerenciamento de Pedidos

Este é um projeto simples em Java que simula um sistema de gerenciamento de pedidos via console. A aplicação permite registrar dados de um cliente, criar um novo pedido associado a ele, adicionar múltiplos itens a este pedido e, ao final, exibir um resumo completo da compra.

## Funcionalidades

- Cadastro de dados do cliente (nome, e-mail, data de nascimento).
- Criação de um pedido com status (ex: `PENDING`, `PROCESSING`).
- Adição de um ou mais itens ao pedido, especificando nome do produto, preço e quantidade.
- Cálculo automático do valor total do pedido.
- Exibição de um sumário formatado com todos os detalhes do cliente e do pedido.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes:

- **`Main.java`**: Classe principal que contém a lógica de interação com o usuário e orquestra a criação dos objetos. É o ponto de entrada da aplicação.
- **`Order.java`**: Modela um pedido. Contém informações do cliente, status, uma lista de itens e o valor total.
- **`OrderItem.java`**: Modela um item dentro de um pedido, com detalhes do produto, quantidade e preço.
- **`Client.java`**: Modela o cliente com seus dados pessoais.
- **`OrderStatus.java`**: `Enum` que define os status possíveis para um pedido (`PENDING`, `PROCESSING`, `SHIPPED`, etc.).
- **`Product.java`**: Modela um produto com nome e preço. _(Nota: Atualmente, os itens do pedido são criados com dados inseridos manualmente, sem vincular a um objeto `Product` predefinido)_.

## Como Executar

1.  Certifique-se de ter o **JDK (Java Development Kit)** instalado em sua máquina.
2.  Abra um terminal na pasta `src` do projeto.
3.  Compile todos os arquivos `.java`:
    ```bash
    javac *.java
    ```
4.  Execute a classe `Main`:
    ```bash
    java Main
    ```
5.  Siga as instruções exibidas no console para inserir os dados do cliente e do pedido.

## Exemplo de Uso

```
Enter Client Data:
Name: Alex Green
Email: alex@gmail.com
Birth Date (DD/MM/YYYY): 15/03/1985
Enter order Data:
Status: PROCESSING
How many items to this order? 2
Enter #1 item data:
Product Name: TV
Product Price: 1000.00
Quantity: 1
Enter #2 item data:
Product Name: Mouse
Product Price: 50.00
Quantity: 2

ORDER SUMMARY:
Order Moment: 29/10/2024 10:30:55
Order status: PROCESSING
Client: Alex Green (15/03/1985 00:00:00) - alex@gmail.com
Order items:
TV, $1000.00, Quantity: 1, Subtotal: $1000.00
Mouse, $50.00, Quantity: 2, Subtotal: $100.00
Total price: $1100.00
```
