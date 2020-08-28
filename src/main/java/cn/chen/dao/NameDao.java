package cn.chen.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface NameDao {
    @Select("select name from nameTable where id=#{id};")
    String getName(int id);
    @Insert("insert into nameTable(name,id) VALUES (#{name},#{id});")
    void saveAccount(@Param("name") String name,@Param("id") int id);
    @Select("select id from nameTable where name=#{name}")
    int getId(String name);
    @Select("select count(1) from nameTable where name=#{name} limit 1 ;")
    int hasName(String name);
}
