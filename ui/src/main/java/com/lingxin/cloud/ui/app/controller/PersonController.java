package com.lingxin.cloud.ui.app.controller;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.model.Person;
import com.lingxin.cloud.ui.app.service.PersonService;
import com.lingxin.cloud.ui.app.service.UiOtherService;
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
    private UiOtherService uiOtherService;

    @RequestMapping("list")
    public JsonReturn list() {
        return personService.findAll();
    }

    @RequestMapping("delete")
    public JsonReturn delete(String id) {
        //return personService.delete(id);
        return uiOtherService.deletePerson(id);
    }

    @RequestMapping("save")
    public JsonReturn save(Person person) {
        return uiOtherService.savePerson(new Person());
    }

}
