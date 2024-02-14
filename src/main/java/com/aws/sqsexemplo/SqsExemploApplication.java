package com.aws.sqsexemplo;

import com.aws.sqsexemplo.model.Order;
import com.aws.sqsexemplo.service.OrderService;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsExemploApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SqsExemploApplication.class, args);
	}

	// Injeta um objeto SqsTemplate para interagir com o SQS
	@Autowired
	private SqsTemplate sqsTemplate;

	@Autowired
	private OrderService orderService;

	// Método executado após a inicialização da aplicação
	@Override
	public void run(String... args) throws Exception {
		// Simulando a criação de um novo pedido
		Order order = Order.createWithRandomId("Renato", 100.0);
		// Enviando o pedido para fila SQS
		orderService.createOrder(order);
	}
}
