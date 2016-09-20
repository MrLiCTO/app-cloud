package com.lingxin.cloud.ui.app.service;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.model.Message;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr_Li on 2016/9/19.
 */
@Service
public class UiMessageService {
    @Autowired
    private RestTemplate restTemplate;

    //增---------post
    @HystrixCommand(fallbackMethod = "failMsgSave")
    public JsonReturn savePerson(Message message) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String jsonString = JSON.toJSONString(message);
        HttpEntity<String> personEntity = new HttpEntity<String>(jsonString, headers);
        return restTemplate.postForEntity("http://message/message/save", personEntity, JsonReturn.class).getBody();
    }

    public JsonReturn failMsgSave(Message message) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        jsonReturn.setData(JSON.toJSONString(message));
        return jsonReturn;
    }


    //删---------delete
    @HystrixCommand(fallbackMethod = "failMsgDelete")
    public JsonReturn deletePerson(String id) {
        restTemplate.delete("http://message/message/delete/{id}", id);
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求成功");
        jsonReturn.setCode(JsonReturn.SUCCESS_CODE);
        return jsonReturn;
    }

    public JsonReturn failMsgDelete(String id) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        jsonReturn.setData(id);
        return jsonReturn;
    }


    //改-----------put
    @HystrixCommand(fallbackMethod = "failMsgEdit")
    public JsonReturn editMessage(Message message) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String jsonString = JSON.toJSONString(message);
        HttpEntity<String> personEntity = new HttpEntity<String>(jsonString, headers);
        restTemplate.put("http://message/message/update", personEntity);//与post请求同理
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求成功");
        jsonReturn.setCode(JsonReturn.SUCCESS_CODE);
        return jsonReturn;
    }

    public JsonReturn failMsgEdit(Message message) {
        return failMsgSave(message);
    }

    //查--------------------get
    @HystrixCommand(fallbackMethod = "failMsgList")
    public JsonReturn msgList() {
        return restTemplate.getForObject("http://message/message/list", JsonReturn.class);
    }

    public JsonReturn failMsgList() {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        return jsonReturn;
    }

    @HystrixCommand(fallbackMethod = "failMsgGetMessage")
    public JsonReturn getMessage(String id) {
        Map map = new HashMap<String, String>();
        map.put("id", id);
        return restTemplate.getForObject("http://message/message/findById/{id}", JsonReturn.class, map);
    }

    public JsonReturn failMsgGetMessage(String id) {
        return failMsgDelete(id);
    }
}
