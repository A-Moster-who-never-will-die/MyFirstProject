package cn.chen.service;

import cn.chen.dao.ExceptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service("exceptionService")
public class ExceptionService {
    @Autowired
    ExceptionDao exceptionDao;
    public void put(String message){
        System.out.println("exceptionService");
        exceptionDao.put(message);
    }
}
