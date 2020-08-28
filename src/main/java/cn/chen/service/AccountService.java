package cn.chen.service;

import cn.chen.bean.Account;
import cn.chen.dao.AccountDao;
import cn.chen.dao.NameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

/**
 * 用于完成关于user表的操作
 */
@Service("accountService")
public class AccountService {
    /**
     * 根据id获取密码
     */
    @Autowired
    AccountDao accountDao;
    @Autowired
    NameDao nameDao;
    public String getPassword(int id){
        System.out.println("getPassword");
        return accountDao.getPassword(id);
    }
    public Account getPassword(String name){
        System.out.println(accountDao.getPasswordByName(name));
        return accountDao.getPasswordByName(name);
    }
    public int getId(String name){
        return nameDao.getId(name);
    }
    /**
     * 储存新的用户
     * @return 返回用户id
     */
    public int saveAccount(String name,String password){
        System.out.println("save account"+password);
        int count=accountDao.getCount()+1;
        accountDao.saveAccount(password,count);
        System.out.println(name+count);
        nameDao.saveAccount(name,count);
        return count;
    }

    /**
     * 查询数据库,查看是否拥有相同名字的人
     * @return 有返回true,没有返回false
     */
    public boolean haveSame(String name){
        System.out.println("haveSame");
        int row=nameDao.hasName(name);
        if (row==0){
            return false;
        }else {
            return true;
        }
    }
}
