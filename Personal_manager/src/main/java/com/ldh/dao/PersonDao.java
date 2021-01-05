package com.ldh.dao;

import com.ldh.domain.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao {

    @Insert("insert into person (num,sex,age,futy,aut,password,name)values(#{num},#{sex},#{age},#{futy},#{aut},#{password},#{name})")
    public void insert(Person person);

    @Select("select * from person")
    public List<Person> queryAll();

    @Select("select * from person where num=#{num}")
    public  List<Person>query(String num);

    @Delete("delete from person where num=#{num}")
    public void delete(String num);
}
