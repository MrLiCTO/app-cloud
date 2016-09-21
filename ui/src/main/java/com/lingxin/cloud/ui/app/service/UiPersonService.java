package com.lingxin.cloud.ui.app.service;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.common.result.JsonReturn;
import com.lingxin.cloud.app.person.model.Person;
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
 * Created by Mr_Li on 2016/9/5.
 */
@Service
public class UiPersonService {
    @Autowired
    private RestTemplate restTemplate;

    //增---------post
    @HystrixCommand(fallbackMethod = "failMsgSave")
    public JsonReturn savePerson(Person person) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String jsonString = JSON.toJSONString(person);
        HttpEntity<String> personEntity = new HttpEntity<String>(jsonString, headers);
        //String id="110";
        //return restTemplate.postForEntity("http://person/person/save?id={id}",null, JsonReturn.class,id).getBody();//成功
        //return restTemplate.postForEntity("http://person/person/save",person, JsonReturn.class).getBody();//成功
        return restTemplate.postForEntity("http://person/person/save", personEntity, JsonReturn.class).getBody();//成功
        //return restTemplate.postForEntity("http://person/person/save",jsonString, JsonReturn.class).getBody();//这样传递失败了
    }

    public JsonReturn failMsgSave(Person person) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        jsonReturn.setData(JSON.toJSONString(person));
        return jsonReturn;
    }


    //删---------delete
    @HystrixCommand(fallbackMethod = "failMsgDelete")
    public JsonReturn deletePerson(String id) {
        Map map = new HashMap<String, String>();
        map.put("id", id);
        //return restTemplate.delete("http://person/person/delete?id=" + id);
        //return restTemplate.delete("http://person/person/delete/{id}",id);
        restTemplate.delete("http://person/person/delete/{id}", map);
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求成功");
        jsonReturn.setCode(JsonReturn.SUCCESS_CODE);
        return jsonReturn;
        //return restTemplate.getForObject("http://person/person/list", JsonReturn.class);
        //return restTemplate.getForObject("http://person/person/delete?id=" + id, JsonReturn.class);
        //return restTemplate.getForObject("http://person/person/delete/{id}", JsonReturn.class,id);
        //return restTemplate.getForObject("http://person/person/delete/{id}", JsonReturn.class,map);

        /*return restTemplate.getForObject("http://localhost:8883/person/list", JsonReturn.class);
        return restTemplate.getForObject("http://localhost:8883/person/delete?id="+id, JsonReturn.class);
        return restTemplate.getForObject("http://localhost:8883/person/delete/{id}", JsonReturn.class,id);
        return restTemplate.getForObject("http://localhost:8883/person/delete/{id}", JsonReturn.class,map);*/ //在不依赖Ribbon注入时这么写

        /*return restTemplate.getForObject("http://localhost:8883/person/delete", JsonReturn.class,map);
        return restTemplate.getForObject("http://person/person/delete", JsonReturn.class,map);*/ // 此种方式是错误的,person服务无法拿到id的值
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
    public JsonReturn editPerson(Person person) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String jsonString = JSON.toJSONString(person);
        HttpEntity<String> personEntity = new HttpEntity<String>(jsonString, headers);
        restTemplate.put("http://person/person/update", personEntity, JsonReturn.class);//与post请求同理
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求成功");
        jsonReturn.setCode(JsonReturn.SUCCESS_CODE);
        return jsonReturn;
    }

    public JsonReturn failMsgEdit(Person person) {
        return failMsgSave(person);
    }

    //查--------------------get
    @HystrixCommand(fallbackMethod = "failMsgList")
    public JsonReturn listPerson() {
        return restTemplate.getForObject("http://person/person/list", JsonReturn.class);
    }

    public JsonReturn failMsgList() {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        return jsonReturn;
    }

    @HystrixCommand(fallbackMethod = "failMsgGetPerson")
    public JsonReturn getPerson(String id) {
        Map map = new HashMap<String, String>();
        map.put("id", id);
        //return restTemplate.getForObject("http://person/person/findById?id="+id,JsonReturn.class);
        //return restTemplate.getForObject("http://person/person/findById/{id}",JsonReturn.class,id);
        return restTemplate.getForObject("http://person/person/findById/{id}", JsonReturn.class, map);
    }

    public JsonReturn failMsgGetPerson(String id) {
        return failMsgDelete(id);
    }
}
