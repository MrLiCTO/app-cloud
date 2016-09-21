package com.lingxin.cloud.person.app;

import com.lingxin.cloud.app.person.model.Person;
import com.lingxin.cloud.app.person.pojo.PersonPojo;
import com.lingxin.cloud.person.app.mapper.PersonCustomMapper;
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
    private PersonCustomMapper personCustomMapper;


    @Test
    public void saveTest() {
        for (int i = 1; i < 36; i++) {
            Person person = new Person();
            person.setAge(i + 10);
            person.setId(i + 10 + "");
            person.setName("百度呵呵" + i);
            person.setSex(i % 2 == 0 ? "男" : "女");
            personCustomMapper.save(person);
        }
    }

    @Test
    public void getTest() {
        Person person = new Person();
        person.setName("%度%");
        PersonPojo pj = new PersonPojo();
        pj.setPerson(person);
        List<Person> list = personCustomMapper.findListByPojo(pj);
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
        List<Person> list = personCustomMapper.selectAllByName(pj);
        for (Person p : list) {
            System.out.println("++++++++++++++++++++++++++++++++++++" + p.getName() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

}
