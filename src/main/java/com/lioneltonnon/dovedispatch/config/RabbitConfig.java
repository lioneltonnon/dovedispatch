package com.lioneltonnon.dovedispatch.config;

import com.lioneltonnon.dovedispatch.config.ApplicationProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory(ApplicationProperties properties) {
        CachingConnectionFactory factory = new CachingConnectionFactory(properties.getHost());
        factory.setPort(properties.getPort());
        factory.setUsername(properties.getUsername());
        factory.setPassword(properties.getPassword());
        factory.setChannelCacheSize(25);
        factory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        factory.setPublisherReturns(true);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMandatory(true); // Necessary for publisher returns
        return template;
    }

    @Bean
    public Queue queue(ApplicationProperties properties) {
        return new Queue(properties.getQueue(), true); // durable queue
    }
}