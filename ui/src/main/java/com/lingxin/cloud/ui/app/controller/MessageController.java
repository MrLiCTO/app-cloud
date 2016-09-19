package com.lingxin.cloud.ui.app.controller;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.model.Message;
import com.lingxin.cloud.ui.app.service.MessageService;
import com.lingxin.cloud.ui.app.service.UiMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr_Li on 2016/9/19.
 */
@RestController
@RequestMapping("messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UiMessageService uiMessageService;

    @RequestMapping("list")
    public JsonReturn list() {
        return messageService.findAll();
        //return uiMessageService.msgList();
    }

    @RequestMapping("delete")
    public JsonReturn delete(String id) {
        id = "1";
        return messageService.delete(id);
        //return uiMessageService.deletePerson(id);
    }

    @RequestMapping("save")
    public JsonReturn save(Message message) {
        message = new Message();
        message.setType("1");
        message.setTitle("消息");
        message.setContent("成功了");
        message.setId("1");
        return messageService.save(message);
        //return uiMessageService.savePerson(message);
    }

    @RequestMapping("findById")
    public JsonReturn findById(String id) {
        id = "1";
        return messageService.findById(id);
        //return uiMessageService.getMessage(id);
    }

    @RequestMapping("update")
    public JsonReturn update(Message message) {
        message = new Message();
        message.setType("1");
        message.setTitle("好好好好------消息");
        message.setContent("成功了");
        message.setId("1");
        return messageService.update(message);
        //return uiMessageService.editMessage(message);
    }
}
