package com.lingxin.cloud.ui.app.service;


import com.lingxin.cloud.app.common.result.JsonReturn;
import com.lingxin.cloud.app.message.model.Message;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mr_Li on 2016/9/5.
 */
@FeignClient("message")
public interface MessageService {
    @RequestMapping(method = RequestMethod.POST, value = "message/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn save(@RequestBody Message message);

    @RequestMapping(method = RequestMethod.DELETE, value = "message/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn delete(@RequestParam("id") String id);

    @RequestMapping(method = RequestMethod.PUT, value = "message/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn update(@RequestBody Message message);

    @RequestMapping(method = RequestMethod.GET, value = "message/list", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn findAll();

    @RequestMapping(method = RequestMethod.GET, value = "message/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn findById(@RequestParam("id") String id);
}
