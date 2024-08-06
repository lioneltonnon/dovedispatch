package com.lioneltonnon.dovedispatch.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory(ApplicationProperties properties) {
        CachingConnectionFactory factory = new CachingConnectionFactory(properties.getRabbitmq().getHost(), properties.getRabbitmq().getPort());
        factory.setUsername(properties.getRabbitmq().getUsername());
        factory.setPassword(properties.getRabbitmq().getPassword());
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue queue(ApplicationProperties properties) {
        return new Queue(properties.getRabbitmq().getQueue(), true); // durable queue
    }
}

