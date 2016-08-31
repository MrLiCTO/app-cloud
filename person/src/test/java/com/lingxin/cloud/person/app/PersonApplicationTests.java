package com.lingxin.cloud.person.app;

import com.lingxin.cloud.person.app.mapper.PersonMapper;
import com.lingxin.cloud.person.app.model.Person;
import com.lingxin.cloud.person.app.model.PersonPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PersonApplication.class)
@WebAppConfiguration
public class PersonApplicationTests {

    @Autowired
    private PersonMapper personMapper;


    @Test
    public void saveTest() {
        Person person = new Person();
        person.setAge(25);
        person.setId("1");
        person.setName("百度盒子");
        person.setSex("男");
        personMapper.save(person);
    }

    @Test
    public void getTest() {
        Person person = new Person();
        person.setName("%度%");
        PersonPojo pj = new PersonPojo();
        pj.setPerson(person);
        List<Person> list = personMapper.findListByPojo(pj);
        for (Person p : list) {
            System.out.println("++++++++++++++++++++++++++++++++++++" + p.getName() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    @Test
    public void findTest() {
        Person person = new Person();
        person.setName("度");
        PersonPojo pj = new PersonPojo();
        pj.setPerson(person);
        List<Person> list = personMapper.selectAllByName(pj);
        for (Person p : list) {
            System.out.println("++++++++++++++++++++++++++++++++++++" + p.getName() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

}
