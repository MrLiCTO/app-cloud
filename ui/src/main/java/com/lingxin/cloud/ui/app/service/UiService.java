package com.lingxin.cloud.ui.app.service;


import com.lingxin.cloud.app.common.result.JsonReturn;
import com.lingxin.cloud.app.message.model.Message;
import com.lingxin.cloud.app.person.model.Person;
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

    //person-----------------------------
    @HystrixCommand(fallbackMethod = "personList")
    public JsonReturn savePerson(Person person) {
        return personService.save(person);
    }

    public JsonReturn personList(Person person) {
        return personService.findAll();
    }

    @HystrixCommand(fallbackMethod = "personList")
    public JsonReturn deletePerson(String id) {
        return personService.delete(id);
    }

    @HystrixCommand(fallbackMethod = "personList")
    public JsonReturn getPersonById(String id) {
        return personService.findById(id);
    }

    public JsonReturn personList(String id) {
        return personService.findAll();
    }

    @HystrixCommand(fallbackMethod = "personList")
    public JsonReturn listPerson() {
        return personService.findAll();
    }

    public JsonReturn personList() {
        return personService.findAll();
    }

    //message----------------------
    @HystrixCommand(fallbackMethod = "messageList")
    public JsonReturn deleteMessage(String id) {
        return messageService.delete(id);
    }

    @HystrixCommand(fallbackMethod = "messageList")
    public JsonReturn getMessageById(String id) {
        return messageService.findById(id);
    }

    public JsonReturn messageList(String id) {
        return messageService.findAll();
    }

    @HystrixCommand(fallbackMethod = "messageList")
    public JsonReturn saveMessage(Message message) {
        return messageService.save(message);
    }

    public JsonReturn messageList(Message message) {
        return messageService.findAll();
    }

    @HystrixCommand(fallbackMethod = "messageList")
    public JsonReturn listMessage() {
        return messageService.findAll();
    }

    public JsonReturn messageList() {
        return messageService.findAll();
    }
}
