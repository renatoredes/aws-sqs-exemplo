package com.aws.sqsexemplo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private SqsAsyncClient sqsAsyncClient;

    @Value("${sqs.order.queue.url}")
    private String sqsQueueUrl;

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper para serialização
    /**
     * Cria um novo pedido e envia para a fila SQS.
     *
     * @param order O pedido a ser enviado para a fila SQS
     */
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
            logger.info("Order sent to SQS: {}", order);
        } catch (JsonProcessingException e) {
            // Lidar com exceção de serialização
            logger.error("Error serializing Order to JSON: {}", e.getMessage());
        } catch (Exception e) {
            // Lidar com outras exceções
            logger.error("Error sending order to SQS: {}", e.getMessage());
        }
    }
}