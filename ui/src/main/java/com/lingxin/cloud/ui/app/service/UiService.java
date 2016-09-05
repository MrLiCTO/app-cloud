package com.lingxin.cloud.ui.app.service;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.model.Message;
import com.lingxin.cloud.ui.app.model.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mr_Li on 2016/9/5.
 */
@Service
public class UiService {
    @Autowired
    private PersonService personService;
    @Autowired
    private MessageService messageService;

    @HystrixCommand(fallbackMethod = "personList")
    public JsonReturn savePerson(Person person) {
        return personService.save(person);
    }

    public JsonReturn personList() {
        return personService.findAll();
    }

    @HystrixCommand(fallbackMethod = "messageList")
    public JsonReturn saveMessage(Message message) {
        return messageService.save(message);
    }

    public JsonReturn messageList() {
        return messageService.findAll();
    }
}
