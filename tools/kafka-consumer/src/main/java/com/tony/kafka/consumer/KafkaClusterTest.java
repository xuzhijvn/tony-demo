package com.tony.kafka.consumer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author tonyxu
 */
public class KafkaClusterTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "tony2c4g:9092");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer())) {
            // 尝试发送一条消息
            ProducerRecord<String, String> record = new ProducerRecord<>("tony_topic", "Hello Kafka, KafkaClusterTest");
            producer.send(record).get();
            System.out.println("Kafka cluster is running fine.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to Kafka cluster.");
        }
    }
}