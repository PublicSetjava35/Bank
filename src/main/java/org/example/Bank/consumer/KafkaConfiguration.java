package org.example.Bank.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class KafkaConfiguration {
    // Не будет отправителем, так как он стал потребителем, Будем использовать (WebClient): как отправителем обычных сообщений
    /*
    @Value("${spring.kafka.bootstrap-servers}")
    private String port;
    @Bean
    public NewTopic topic() {
        return new NewTopic("my-topic", 3, (short)1);
    }
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> key = new HashMap<>();
        key.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, port);
        key.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        key.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(key);
    }
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
    */
}