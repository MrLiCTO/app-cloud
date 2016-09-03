package com.lingxin.cloud.message.app.controller;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.message.app.model.JsonReturn;
import com.lingxin.cloud.message.app.model.Message;
import com.lingxin.cloud.message.app.service.MessageService;
import com.lingxin.cloud.message.app.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr_Li on 2016/9/2.
 */
@RestController
@RequestMapping("message")
public class MessageCotroller {
    @Autowired
    private MessageService messageService;
    @Value("${my.message}")
    private String msg;

    @RequestMapping("list")
    public JsonReturn list() {
        JsonReturn res = new JsonReturn();
        List<Message> list = messageService.findAll();
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setData(JSON.toJSONString(list));
        res.setMsg(msg);
        return res;
    }

    @RequestMapping("save")
    public JsonReturn save(Message message) {
        JsonReturn res = new JsonReturn();
        messageService.save(message);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg(msg);
        return res;
    }

    @RequestMapping("delete")
    public JsonReturn save(String id) {
        JsonReturn res = new JsonReturn();
        messageService.delete(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg(msg);
        return res;
    }

    @RequestMapping("update")
    public JsonReturn update(Message message) {
        JsonReturn res = new JsonReturn();
        Message mess;
        if (message != null) {
            mess = messageService.findById(message.getId());
            if (mess != null) {
                BeanUtils.copyProperties(message, mess);
                messageService.save(mess);
                res.setMsg(msg);
                res.setCode(JsonReturn.SUCCESS_CODE);
            } else {
                res.setMsg("更新失败了...");
                res.setCode(JsonReturn.ERROR_CODE);
            }
        }
        return res;
    }
}
