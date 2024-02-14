package com.aws.sqsexemplo.consumer;

import com.aws.sqsexemplo.model.Order;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @SqsListener(value = "order-queue")
    public void listen(@Payload Order order) {
        System.out.println("Received new order: " + order);
        // Aqui você pode processar o pedido, como salvá-lo no banco de dados ou enviá-lo para outro serviço
    }
}
