package com.aws.sqsexemplo.consumer;

import com.aws.sqsexemplo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    /**
     * Método que escuta a fila SQS e processa novos pedidos.
     *
     * @param order O pedido recebido da fila SQS
     */
    @SqsListener(value = "order-queue")
    public void listen(@Payload Order order) {
        try {
            logger.info("Received new order: {}", order);

            // Aqui você pode processar o pedido, como salvá-lo no banco de dados ou enviá-lo para outro serviço
        } catch (Exception e) {
            logger.error("Error processing order: {}", e.getMessage());
            // Lidar com exceções durante o processamento do pedido
        }
    }
}