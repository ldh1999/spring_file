package com.ldh.dao;

import com.ldh.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {
    @Insert("insert into notice(num,subject,word)values(#{num},#{subject},#{word})")
    public void insert(Notice notice);

    @Select("select * from notice")
    public List<Notice> queryall();

    @Select("select * from notice where num=#{num}")
    public List<Notice> query(String num);

    @Delete("delete from notice where num =#{num}")
    public void delete(String num);

}
