package com.lingxin.cloud.ui.app.controller;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.model.Person;
import com.lingxin.cloud.ui.app.service.PersonService;
import com.lingxin.cloud.ui.app.service.UiPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr_Li on 2016/9/8.
 */
@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private UiPersonService uiPersonService;

    @RequestMapping("list")
    public JsonReturn list() {
        return personService.findAll();
    }

    @RequestMapping("delete")
    public JsonReturn delete(String id) {
        id = "9999";
        return personService.delete(id);
        //return uiPersonService.deletePerson(id);
    }

    @RequestMapping("save")
    public JsonReturn save(Person person) {
        person = new Person();
        person.setId("9999");
        person.setAge(20);
        person.setName("haoren");
        person.setSex("男");
        return personService.save(person);
        //return uiPersonService.savePerson(person);
    }

    @RequestMapping("findById")
    public JsonReturn findById(String id) {
        id = "9999";
        return personService.findById(id);
        //return uiPersonService.getPerson(id);
    }

    @RequestMapping("update")
    public JsonReturn update(Person person) {
        person = new Person();
        person.setId("9999");
        person.setAge(20);
        person.setName("哈哈");
        person.setSex("女");
        return personService.update(person);
        //return uiPersonService.editPerson(person);
    }

}
