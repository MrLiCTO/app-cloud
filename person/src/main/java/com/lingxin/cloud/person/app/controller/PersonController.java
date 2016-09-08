package com.lingxin.cloud.person.app.controller;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.person.app.model.Person;
import com.lingxin.cloud.person.app.response.JsonReturn;
import com.lingxin.cloud.person.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr_Li on 2016/8/31.
 */
@RestController
@RequestMapping("person")
public class PersonController {
    //@Autowired
    //private PersonCustomMapper personCustomMapper;
    @Autowired
    private PersonService personService;

    @RequestMapping("list")
    public JsonReturn list() {
        JsonReturn res = new JsonReturn();
        //List<Person> persons=personCustomMapper.findList("%度%");
        List<Person> list = personService.findAll();
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        res.setData(JSON.toJSONString(list));
        return res;
    }

    @RequestMapping("save")
    public JsonReturn save(Person person) {
        JsonReturn res = new JsonReturn();
        personService.save(person);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        return res;
    }

    @RequestMapping("delete")
    public JsonReturn save(@RequestParam("id") String id) {
        JsonReturn res = new JsonReturn();
        personService.delete(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        return res;
    }

    @RequestMapping("update")
    public JsonReturn update(Person person) {
        JsonReturn res = new JsonReturn();
        personService.update(person);
        res.setMsg("hello world");
        res.setCode(JsonReturn.SUCCESS_CODE);
        return res;
    }
}
