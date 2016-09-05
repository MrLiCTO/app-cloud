package com.lingxin.cloud.ui.app.service;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.model.Message;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mr_Li on 2016/9/5.
 */
@FeignClient("message")
public interface MessageService {
    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn save(@RequestBody Message message);

    @RequestMapping(method = RequestMethod.GET, value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn delete(@RequestBody String id);

    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn update(@RequestBody Message message);

    @RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    JsonReturn findAll();
}
