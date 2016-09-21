package com.lingxin.cloud.message.app.controller;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.common.result.JsonReturn;
import com.lingxin.cloud.app.common.utils.BeanUtils;
import com.lingxin.cloud.app.message.model.Message;
import com.lingxin.cloud.message.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public JsonReturn list() {
        JsonReturn res = new JsonReturn();
        List<Message> list = messageService.findAll();
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setData(JSON.toJSONString(list));
        res.setMsg(msg);
        return res;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public JsonReturn save(@RequestBody Message message) {
        JsonReturn res = new JsonReturn();
        messageService.save(message);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg(msg);
        return res;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public JsonReturn save(@PathVariable("id") String id) {
        JsonReturn res = new JsonReturn();
        messageService.delete(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg(msg);
        return res;
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public JsonReturn findById(@PathVariable("id") String id) {
        JsonReturn res = new JsonReturn();
        Message message = messageService.findById(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg(msg);
        res.setData(JSON.toJSONString(message));
        return res;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public JsonReturn update(@RequestBody Message message) {
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
