package com.lingxin.cloud.person.app.rabbitMQ;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.person.model.Person;
import com.lingxin.cloud.person.app.mapper.PersonMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mr_Li on 2016/9/27.
 */
@Component
public class MssageReceiver {
    @Autowired
    private PersonMapper personMapper;

    @RabbitListener(queues = "person")
    public void receiver(String msg) {
        final Person person = JSON.parseObject(msg, Person.class);
        personMapper.insert(person);
    }
}
