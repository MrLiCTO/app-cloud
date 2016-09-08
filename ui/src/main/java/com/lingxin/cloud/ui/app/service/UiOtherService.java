package com.lingxin.cloud.ui.app.service;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate.getForObject("http://localhost/person/person/delete", JsonReturn.class, id);
    }

    public JsonReturn failMsg(String msg) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setMsg("请求失败");
        jsonReturn.setCode(JsonReturn.ERROR_CODE);
        return jsonReturn;
    }
}
