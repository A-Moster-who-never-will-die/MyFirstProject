package cn.chen.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface HeadDao {
    @Select("select img from headImg where id=#{id};")
    public byte[]getImg( int id);
    @Select("select count(1) from headImg where id=#{id} limit 1 ;")
    int hasId(int id);
    @Insert("insert into headImg (id, img) VALUES (#{id},#{img})")
    void save(@Param("id") int id,@Param("img") byte[]img);
    @Update("update headImg set img=#{img} where id=#{id}")
    void update(@Param("id") int id,@Param("img") byte[]img);
}
