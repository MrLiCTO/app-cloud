package com.lingxin.cloud.ui.app.service;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr_Li on 2016/9/5.
 */
@Service
public class UiOtherService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "failMsg")
    public JsonReturn deletePerson(String id) {
        System.out.print(id);
        Map map = new HashMap<String, String>();
        map.put("id", id);
        /*Person person = new Person();
        person.setAge(10);
        person.setId(100+"");
        person.setName("百度呵呵");
        person.setSex("女") ;
        restTemplate.postForEntity("http://localhost:8883/person/save,null,JsonReturn.class,person);*/
        //return restTemplate.getForObject("http://localhost:8883/person/list", JsonReturn.class);
        return restTemplate.getForObject("http://person/person/list", JsonReturn.class);
        //return restTemplate.getForObject("http://localhost:8883/person/delete?id="+id, JsonReturn.class);
        //return restTemplate.getForObject("http://localhost:8883/person/delete/{id}", JsonReturn.class,id);
        //return restTemplate.getForObject("http://localhost:8883/person/delete/{id}", JsonReturn.class,map);
        //return restTemplate.getForObject("http://localhost:8883/person/delete", JsonReturn.class,map);//此种方式是错误的,person服务无法拿到id的值
    }

    public JsonReturn failMsg(String msg) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        return jsonReturn;
    }
}
