package com.lingxin.cloud.ui.app.rabbitMQ;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.person.model.Person;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mr_Li on 2016/9/27.
 */
@Component
public class MssageSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        Person person = new Person();
        person.setAge(25);
        person.setId(999 + 10 + "");
        person.setName("百度呵呵999");
        person.setSex("男");
        String context = JSON.toJSONString(person);
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("person", context);
    }
}
