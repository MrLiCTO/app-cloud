package com.lingxin.cloud.message.app;

import com.lingxin.cloud.message.app.model.Person;
import com.lingxin.cloud.message.app.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MessageApplication.class)
@WebAppConfiguration
public class MessageApplicationTests {
	@Autowired
	private PersonRepository personRepository;
	@Test
	public void contextLoads() {
		Person p = new Person();
		p.setAge(25);
		p.setId("1");
		p.setName("百度盒子");
		p.setSex("男");
		personRepository.save(p);
	}

}
