/**
 * Author: komiloff_doniyor2505@gmail.com
 * Date:3/4/2023
 * Time:10:15 AM
 * Project Name:rabbitMq-example
 */
package com.example;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.routing.key}")
    private String routing_key;

    public void send(Employee company) {
        rabbitTemplate.convertAndSend(exchange, routing_key, company);
        System.out.println("Send msg = " + company);

    }
}
