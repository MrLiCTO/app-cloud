package com.lingxin.cloud.person.app.batch;

import com.lingxin.cloud.app.person.model.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import java.util.UUID;

/**
 * Created by Mr_Li on 2016/10/3.
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {
    @Override
    public Person process(Person item) throws ValidationException {
        super.process(item);
        item.setId(UUID.randomUUID().toString());
        if (item.getSex().equals("1")) {
            item.setSex("男");
        } else {
            item.setSex("女");
        }
        return item;
    }
}
