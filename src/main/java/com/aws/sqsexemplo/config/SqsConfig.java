package com.aws.sqsexemplo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import java.net.URI;

@Configuration
public class SqsConfig {

    // Injeta a URL local da fila SQS
    @Value("${local.url}")
    private String localUrl;

    @Autowired
    private ObjectMapper objectMapper;

    // Método que configura e retorna um cliente SQS
    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        // Cria um cliente SQS usando a AWS SDK v2
        return SqsAsyncClient.builder()
                // Substitui o endpoint padrão pelo endpoint local definido
                .endpointOverride(URI.create(localUrl))
                // Define a região do cliente SQS
                .region(Region.SA_EAST_1)
                // Constrói e retorna a instância do cliente SQS configurado
                .build();
    }
    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setObjectMapper(objectMapper);
        return messageConverter;
    }
}