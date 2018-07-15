package com.lancq.user.notify;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * @Author lancq
 * @Description
 * @Date 2018/7/15
 **/
public class RegistryListener implements MessageListener<Integer,String> {
    Logger Log = LoggerFactory.getLogger(RegistryListener.class);

    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
        Log.info("收到消息了");
        Log.info(integerStringConsumerRecord.value());

    }
}
