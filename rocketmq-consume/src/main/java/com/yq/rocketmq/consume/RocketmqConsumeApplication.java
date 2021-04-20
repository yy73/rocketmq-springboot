package com.yq.rocketmq.consume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

@SpringBootApplication
public class RocketmqConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqConsumeApplication.class, args);
    }

//    //    @Slf4j
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
//    public class MyConsumer1 implements RocketMQListener<String> {
//        public void onMessage(String message) {
//            System.out.println("received message: " + message);
////            log.info("received message: {}", message);
//        }
//    }

    //    @Slf4j
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
//    public class MyConsumer2 implements RocketMQListener<OrderPaidEvent> {
//        public void onMessage(OrderPaidEvent orderPaidEvent) {
//            System.out.println("received orderPaidEvent: {}" + orderPaidEvent);
////            log.info("received orderPaidEvent: {}", orderPaidEvent);
//        }
//    }

//    @Data
//    @AllArgsConstructor
//    class OrderPaidEvent {
//        private String orderId;
//
//        private BigDecimal paidMoney;
//    }
}
