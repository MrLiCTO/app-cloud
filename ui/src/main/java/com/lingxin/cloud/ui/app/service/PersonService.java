package com.lingxin.cloud.ui.app.service;


import com.lingxin.cloud.app.common.result.JsonReturn;
import com.lingxin.cloud.app.person.model.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mr_Li on 2016/9/5.
 */
@FeignClient("person")
public interface PersonService {
    @RequestMapping(method = RequestMethod.POST, value = "person/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn save(@RequestBody Person person);

    /*@RequestMapping(method = RequestMethod.GET, value = "person/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn delete(@RequestParam("id") String id);*/

    @RequestMapping(method = RequestMethod.DELETE, value = "person/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn delete(@RequestParam("id") String id);

    @RequestMapping(method = RequestMethod.PUT, value = "person/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn update(@RequestBody Person person);

    @RequestMapping(method = RequestMethod.GET, value = "person/list", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn findAll();

    @RequestMapping(method = RequestMethod.GET, value = "person/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn findById(@RequestParam("id") String id);
}
