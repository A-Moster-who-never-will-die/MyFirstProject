package cn.chen.dao;

import org.apache.ibatis.annotations.Insert;

import java.sql.Time;

public interface ExceptionDao {
    @Insert("insert into exception(time, message) VALUES (now(),#{message})")
    void put(String message);
}
