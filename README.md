# Exemplo de Publicação e Consumo de Mensagens com AWS SQS e Spring Cloud para um sistema de pedidos


[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-11%2B-red)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3+-green)](https://spring.io/projects/spring-boot)
[![AWS SDK](https://img.shields.io/badge/AWS%20SDK%20v2+-blue)](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-3+-blue)](https://spring.io/projects/spring-cloud)

Este projeto é um exemplo de integração com o Amazon Simple Queue Service (SQS) utilizando o Spring Boot e o Spring Cloud para um sistema de pedidos online.

## Descrição

O sistema de pedidos online tem como objetivo enviar informações do pedido para uma fila SQS quando uma nova ordem é recebida. Isso é útil para processar os pedidos de forma assíncrona e escalável, garantindo que as informações do pedido sejam entregues com segurança e confiabilidade.

O projeto demonstra como criar e consumir mensagens de uma fila SQS da AWS (Amazon Web Services) usando o Spring Boot em conjunto com o Spring Cloud.<br /><br />
Nesse primeiro momento, a publicação e o consumo de mensagens são tratados dentro da mesma aplicação. Ainda não implementei o conjunto de endpoints REST que permite a interação do sistema diretamente com a aplicação.

## Componentes Principais:
- Aplicação Spring Boot: Representa a aplicação que recebe e processa os pedidos.
- Amazon SQS: Representa o serviço de fila de mensagens da AWS, onde as mensagens de pedido são armazenadas.
- LocalStack (Opcional): Representa a ferramenta utilizada para simular serviços da AWS localmente durante o desenvolvimento.
- Pedido Consumido SQS: O pedido é consumido da fila SQS pela aplicação Spring Boot para processamento.

## Fluxo de Mensagens:
- Pedido Recebido: Um pedido é recebido pela aplicação Spring Boot.
- Pedido Enviado para SQS: O pedido é encapsulado em uma mensagem e enviado para a fila SQS.

## Desenho técnico
![sistema_pedidos](https://github.com/renatoredes/aws-sqs-exemplo/assets/18330802/7a3fcc49-6935-458f-913c-ce495834b6cb)


## Interações entre Componentes
- A aplicação Spring Boot interage diretamente com a fila SQS para enviar e consumir mensagens de pedido.
- Durante o desenvolvimento local, a aplicação Spring Boot interage com o LocalStack, que simula os serviços da AWS, incluindo o SQS.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Cloud
- AWS SDK v2
- LocalStack (para desenvolvimento local)
## Classes de Publicação e Consumo

- **Classe de Publicação:** `OrderService`
- **Classe de Consumo:** `OrderConsumer`

## Classe Principal

- **Classe Principal:** `SqsExemploApplication`
    - A classe principal `SqsExemploApplication` é a entrada do aplicativo Spring Boot. Ela inicializa o contexto da aplicação Spring Boot, injeta as dependências necessárias e, após a inicialização, cria e envia um novo pedido para a fila SQS para iniciar o fluxo de processamento de pedidos.

## Configuração

Antes de executar o projeto, certifique-se de ter configurado as seguintes propriedades:

- Configure as credenciais da AWS no seu ambiente ou utilize o LocalStack para simular os serviços da AWS localmente.
- Defina as configurações da fila SQS, como URL e região, no arquivo de propriedades.

Exemplo de configuração da fila SQS no arquivo `application.properties`:

* sqs.order.queue.url

## Execução

Para utilizar o LocalStack para desenvolvimento local:

- Instale o LocalStack conforme as instruções em: [LocalStack](https://github.com/localstack/localstack).
- Defina as configurações da fila SQS para apontar para o endpoint local do LocalStack.

## Execução

Para executar o projeto, siga estas etapas:

1. Clone o repositório para sua máquina local.
2. Certifique-se de ter configurado as propriedades da fila SQS conforme mencionado acima.
3. Execute a aplicação Spring Boot.

Exemplo de execução usando Maven:

* mvn spring-boot:run


### 
Ao final da execução do projeto, será possível verificar no log tanto a publicação quanto o consumo das mensagens na fila SQS.
````
INFO - Order sent to SQS: Order{orderId='número gerado aleatório', customerName='Renato', amount=100.0}
INFO - Received new order: Order{orderId='número gerado aleatório', customerName='Renato', amount=100.0}
````
![img.png](src/main/resources/static/img.png)

## Documentação

- [Documentação do Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação do Spring Cloud AWS](https://docs.awspring.io/spring-cloud-aws/docs/3.1.0/reference/html/index.html#starter-dependencies)
- [Documentação da AWS SDK v2](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html)

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias, correções de bugs ou novos recursos.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
