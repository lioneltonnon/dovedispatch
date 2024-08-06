package com.lioneltonnon.dovedispatch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private Rabbitmq rabbitmq = new Rabbitmq();

    public Rabbitmq getRabbitmq() {
        return rabbitmq;
    }

    public void setRabbitmq(Rabbitmq rabbitmq) {
        this.rabbitmq = rabbitmq;
    }

    public static class Rabbitmq {
        private String host;
        private int port;
        private String username;
        private String password;
        private String queue;

        // Getters and setters
        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getQueue() {
            return queue;
        }

        public void setQueue(String queue) {
            this.queue = queue;
        }
    }
}
