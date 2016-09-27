package com.lingxin.cloud.ui.app;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.person.model.Person;
import com.lingxin.cloud.ui.app.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UiApplication.class)
@WebAppConfiguration
public class UiApplicationTests {

    /*@Autowired
    private UiPersonService uiPersonService;
    @Autowired
    private PersonService personService;*/

    @Autowired
    private AsyncTask task;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void contextLoads() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
        //JsonReturn jsonReturn = uiPersonService.deletePerson("1");
        //System.out.print(JSON.toJSON(personService.findAll()));
    }

    @Test
    public void send() {
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setAge(25);
            person.setId(999 + 10 + i + "i");
            person.setName("百度呵呵999" + i);
            person.setSex("男");
            String context = JSON.toJSONString(person);
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("person", context);
        }
    }
}
