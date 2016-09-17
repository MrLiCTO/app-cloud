package com.lingxin.cloud.person.app.service.impl;

import com.lingxin.cloud.person.app.mapper.PersonCustomMapper;
import com.lingxin.cloud.person.app.mapper.PersonMapper;
import com.lingxin.cloud.person.app.model.Person;
import com.lingxin.cloud.person.app.model.PersonExample;
import com.lingxin.cloud.person.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr_Li on 2016/9/2.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonCustomMapper personCustomMapper;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public void save(Person person) {
        personMapper.insert(person);
    }

    @Override
    public void delete(String id) {
        personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Person findById(String id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Person person) {
        personMapper.updateByPrimaryKey(person);
    }

    @Override
    public List<Person> findAll() {
        return personMapper.selectByExample(new PersonExample());
    }
}
