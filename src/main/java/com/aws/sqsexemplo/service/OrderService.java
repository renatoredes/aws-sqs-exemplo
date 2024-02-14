package com.aws.sqsexemplo.service;

import com.aws.sqsexemplo.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class OrderService {

    @Autowired
    private SqsAsyncClient sqsAsyncClient;

    @Value("${sqs.order.queue.url}")
    private String sqsQueueUrl;

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper para serialização

    public void createOrder(Order order) {
        try {
            // Serializa o objeto Order para JSON
            String orderJson = objectMapper.writeValueAsString(order);

            // Cria a requisição para enviar a mensagem
            SendMessageRequest request = SendMessageRequest.builder()
                    .queueUrl(sqsQueueUrl)
                    .messageBody(orderJson)
                    .build();

            // Envia a mensagem para a fila SQS
            sqsAsyncClient.sendMessage(request).join();
            System.out.println("Order sent to SQS: " + order);
        } catch (JsonProcessingException e) {
            // Lidar com exceção de serialização
            System.err.println("Error serializing Order to JSON: " + e.getMessage());
        }
    }
}
