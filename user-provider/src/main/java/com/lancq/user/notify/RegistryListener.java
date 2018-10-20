package com.lancq.user.notify;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/15
 **/
@Service
public class RegistryListener implements MessageListener<Integer,String> {
    Logger Log = LoggerFactory.getLogger(RegistryListener.class);

    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
        Log.info("收到消息了");
        Log.info(integerStringConsumerRecord.value());
        System.out.println("收到消息了");
        System.out.println(integerStringConsumerRecord.value());

    }
}
