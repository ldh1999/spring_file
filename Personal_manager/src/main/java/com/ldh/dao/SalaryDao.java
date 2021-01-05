package com.ldh.dao;

import com.ldh.domain.Salary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDao {
    @Insert("insert into salary(num,base,bonus,penalty,sum)values(#{num},#{base},#{bonus},#{penalty},#{sum})")
    public void insert(Salary salary);

    @Select("select * from salary where num=#{num}")
    public List<Salary> query(String num);

    @Delete("delete from salary where num= #{num}")
    public void delete(String num);
}
