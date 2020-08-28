package cn.chen.dao;

import cn.chen.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用于Account的dao类
 */
public interface AccountDao {
    @Select("select password from account where  id=#{id};")
    String getPassword(int id);
    @Insert("insert into account ( id,password,loginTime) VALUES (#{id},#{password},now());")
    void saveAccount(@Param("password") String password,@Param("id") int id);
    @Select("select count(1) from account;")
    int getCount();
    @Select("select account.id, password,classId from account , nameTable where  account.id=nameTable.id AND nameTable.name=#{name};")
    Account getPasswordByName(String name);

}
