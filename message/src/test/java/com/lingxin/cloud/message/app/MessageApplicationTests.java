package com.lingxin.cloud.message.app;

import com.lingxin.cloud.message.app.model.Message;
import com.lingxin.cloud.message.app.repository.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MessageApplication.class)
@WebAppConfiguration
public class MessageApplicationTests {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            m.setContent("测试message模块" + i);
            m.setTitle("测试" + i);
            m.setType("消息" + i);
            messageRepository.save(m);
        }
    }

}
