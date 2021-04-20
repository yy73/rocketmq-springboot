package com.yq.rocketmq.produce.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class ProduceRunner implements CommandLineRunner {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {
        // 发送同步消息
        // 在同一个topic中发送100条数据，根据不同的tag实现不同的业务
        //        for (int i = 0; i < 100; i++) {
        //            if (i % 2 == 0) {
        //                /**
        //                 * 发送到指定topic的tag
        //                 * 格式：test-topic-1:tag1
        //                 *  topic： test-topic-1
        //                 *  tag： tag1
        //                 */
        //                rocketMQTemplate.send("test-topic-1:tag1",
        //                        MessageBuilder.withPayload("hello rocketmq" + i)
        //                                .build());
        //            } else {
        //                rocketMQTemplate.send("test-topic-1:tag2",
        //                        MessageBuilder.withPayload("hello rocketmq" + i)
        //                                .build());
        //            }
        //        }


/**
 * 异步发送消息
 */
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            //发送异步消息
//            rocketMQTemplate.asyncSend("test-topic-async",
//                    "测试发送异步消息---->>>>>>" + i + "<------------->" + Calendar.getInstance().getTimeInMillis(),
//                    new SendCallback() { // SendCallback接收异步返回结果的回调
//                        @Override
//                        public void onSuccess(SendResult sendResult) {
//                            System.out.printf("async onSucess SendResult=%s %n", sendResult);
//                        }
//
//                        @Override
//                        public void onException(Throwable throwable) {
//                            System.out.printf("async onException Throwable=%s %n", throwable);
//                        }
//                    }, 10);
//        }


        /**
         * 测试异步延时消息发送
         */
        rocketMQTemplate.asyncSend("test-topic-async",
                new Message<String>() {
                    @Override
                    public String getPayload() {
//                        System.out.println("测试发送异步延时消息---->>>>>>" + Calendar.getInstance().getTime());
                        return "测试发送异步延时消息---->>>>>>" + Calendar.getInstance().getTime();
                    }

                    @Override
                    public MessageHeaders getHeaders() {
                        return null;
                    }
                },
                new SendCallback() { // SendCallback接收异步返回结果的回调
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.printf("async onSucess SendResult=%s %n", sendResult);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        System.out.printf("async onException Throwable=%s %n", throwable);
                    }
                }, 10, 3);

    }
}
