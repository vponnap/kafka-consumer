package com.kafka.consumer.kafkaconsumer.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

 @Component
 public class KafkaReceiver {
	 
  private final Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);
   
   @Value("${kafka.consumer.topic}")
   //private String[] topics;
	private String topics;
   
   
   @KafkaListener(topics = "#{'${kafka.consumer.topic}'.split(',')}", groupId = "${kafka.consumer.group.id.config}")
   public void consumerTopics(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topics)
   
//   @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.group.id.config}")
//  public void consumerTopics(String message)
//  
   {
	   System.out.println("Kafka topic is" + topics);
     //for ( int i =0; i<topics.length; ++i) {
	   logger.info(String.format("#### -> Consumed message is -> %s" , message + "Topics are" + topics));
	 
  //}
}
 }