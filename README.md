# lab-padroes-projeto-spring

# Projeto de Cadastro de Clientes com Padrões de Projeto em Spring Boot

Este é um projeto Spring Boot que utiliza os padrões de projeto Singleton, Strategy e Facade para implementar uma API de cadastro de clientes com endereço, consumindo informações da API externa ViaCEP.

ℹ️ **Breve Explicação dos Padrões de Projeto:**

### Singleton
O padrão Singleton é utilizado para garantir que uma classe tenha apenas uma instância e fornecer um ponto de acesso global a essa instância. Isso é útil quando é desejável ter apenas uma única instância de uma classe em toda a aplicação, como é o caso de objetos que gerenciam recursos compartilhados, configurações ou conexões de banco de dados.

### Strategy
O padrão Strategy é utilizado para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Ele permite que o algoritmo varie independentemente dos clientes que o utilizam, facilitando a alteração ou extensão do comportamento de um objeto em tempo de execução.

### Facade
O padrão Facade é utilizado para fornecer uma interface unificada simplificada para um conjunto de interfaces em um subsistema. Ele oculta a complexidade do subsistema e fornece um ponto de entrada único para interagir com ele, facilitando o uso para os clientes.

---

## 🚀 Implementação do Projeto:

### Singleton
- Utilizamos o padrão Singleton para garantir que a classe de acesso aos dados externos, responsável por consumir a API ViaCEP, tenha apenas uma instância em toda a aplicação. Isso é alcançado através da criação de um método estático público que retorna a instância única da classe e um construtor privado que impede a instanciação direta da classe.

### Strategy
- O padrão Strategy é aplicado na camada de serviço, onde definimos uma interface que especifica os métodos para operações de cadastro de clientes. Em seguida, implementamos várias estratégias (ou serviços) concretos que realizam a persistência dos dados em diferentes fontes, como em memória ou em um banco de dados. Isso permite trocar facilmente a estratégia de persistência sem modificar o código do cliente.

### Facade
- Na camada de controle, utilizamos o padrão Facade para fornecer uma interface simplificada para a API de cadastro de clientes. Através dessa fachada, os clientes podem interagir com o subsistema de cadastro de forma transparente, sem precisar lidar diretamente com a complexidade das integrações com a API ViaCEP ou com a lógica de persistência.

---

## 🛠️ Tecnologias Utilizadas:
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Feign Client para integração com a API ViaCEP

---
