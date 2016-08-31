package com.lingxin.cloud.person.app.mapper;

import com.lingxin.cloud.person.app.model.Person;
import com.lingxin.cloud.person.app.model.PersonPojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {
	@Insert("INSERT INTO person(id,name,sex,age) VALUES(#{id},#{name},#{sex},#{age})")
	public void save(Person person);
	@Select("select * from person where name like #{name}")
	public List<Person> findList(String name);
	@Select("select * from person where name like #{person.name}")
	public List<Person> findListByPojo(PersonPojo personPojo);
	
	public List<Person> selectAllByName(PersonPojo personPojo);
}
