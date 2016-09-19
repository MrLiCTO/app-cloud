package com.lingxin.cloud.ui.app;

import com.lingxin.cloud.ui.app.model.JsonReturn;
import com.lingxin.cloud.ui.app.service.PersonService;
import com.lingxin.cloud.ui.app.service.UiPersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UiApplication.class)
@WebAppConfiguration
public class UiApplicationTests {

    @Autowired
    private UiPersonService uiPersonService;
    @Autowired
    private PersonService personService;

    @Test
    public void contextLoads() {
        JsonReturn jsonReturn = uiPersonService.deletePerson("1");
        //System.out.print(JSON.toJSON(personService.findAll()));
    }

}
