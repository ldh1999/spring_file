package com.ldh.dao;

import com.ldh.domain.Manager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerDao {
    @Insert("insert into manager (num,name,password) values (#{num},#{name},#{password})")
    public void insert(Manager manager);

    @Select("select * from manager where num=#{num}")
    public List<Manager> query(String num);
}
