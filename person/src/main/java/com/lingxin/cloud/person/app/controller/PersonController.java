package com.lingxin.cloud.person.app.controller;

import com.alibaba.fastjson.JSON;
import com.lingxin.cloud.app.common.result.JsonReturn;
import com.lingxin.cloud.app.person.model.Person;
import com.lingxin.cloud.person.app.mapper.PersonCustomMapper;
import com.lingxin.cloud.person.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mr_Li on 2016/8/31.
 */
@RestController
@RequestMapping("person")
@RefreshScope
public class PersonController {
    @Autowired
    private PersonCustomMapper personCustomMapper;
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public JsonReturn list() {
        JsonReturn res = new JsonReturn();
        //List<Person> persons=personCustomMapper.findList("%度%");
        List<Person> list = personService.findAll();
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        res.setData(JSON.toJSONString(list));
        return res;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public JsonReturn save(@RequestBody Person person) {
        JsonReturn res = new JsonReturn();
        personService.save(person);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        return res;
    }

    /*@RequestMapping("delete")
    public JsonReturn delete(String id) {
        JsonReturn res = new JsonReturn();
        personService.delete(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        return res;
    }*/

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public JsonReturn delete(@PathVariable(value = "id") String id) {
        JsonReturn res = new JsonReturn();
        personService.delete(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        return res;
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public JsonReturn findById(@PathVariable(value = "id") String id) {
        JsonReturn res = new JsonReturn();
        Person person = personService.findById(id);
        res.setCode(JsonReturn.SUCCESS_CODE);
        res.setMsg("hello world");
        res.setData(JSON.toJSONString(person));
        return res;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public JsonReturn update(@RequestBody Person person) {
        JsonReturn res = new JsonReturn();
        personService.update(person);
        res.setMsg("hello world");
        res.setCode(JsonReturn.SUCCESS_CODE);
        return res;
    }
}
