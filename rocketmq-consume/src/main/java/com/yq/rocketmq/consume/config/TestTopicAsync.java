package com.yq.rocketmq.consume.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * 测试接收异步消息
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-async", consumerGroup = "topic-async")
public class TestTopicAsync implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("接收到异步延时消息：-》》》》》》》》》》" + s + "<------->" + Calendar.getInstance().getTime());
    }
}
