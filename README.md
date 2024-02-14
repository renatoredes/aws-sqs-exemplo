# Exemplo: AWS SQS 

Exemplo Publicando mensagem SQS e consumindo

![img_1.png](img_1.png)

Documentação:
https://docs.aws.amazon.com/pt_br/sqs/?icmpid=docs_homepage_serverless

LocalStack

![img.png](img.png)

Documentação Spring Cloud
https://docs.awspring.io/spring-cloud-aws/docs/3.1.0/reference/html/index.html#starter-dependencies


``
- src
    - main
        - java
            - com
                - aws
                    - sqsexemplo
                        - application
                            - SqsExemploApplication.java
                        - domain
                            - model
                                - MyMessage.java
                            - service
                                - SqsMessageService.java
                        - infrastructure
                            - config
                                - SQSConfig.java
                            - message
                                - SqsMessageSender.java

``
[![Linguagem Java](https://img.shields.io/badge/Linguagem-Java-orange)](https://www.java.com/)

![Java](https://img.shields.io/badge/Java-000?style=for-the-badge&logo=java)
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg??style=for-the-badge&logo=openjdk&logoColor=white)