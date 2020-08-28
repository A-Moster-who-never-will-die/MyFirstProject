package cn.chen.aspect;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service的切面类
 */
@Aspect
@Component("accountAspect")
public class ServiceAspect {
    @Autowired
    SqlSession sqlSession;

    /**
     * 切入点表达式service下所有类的方法
     */
    @Pointcut("execution(* cn.chen.service.*.*(..))")
    public void pt1(){}
    @AfterReturning("pt1()")
    public void afterReturn(){
        System.out.println("执行了commit");
        sqlSession.commit();
    }
    @Before("pt1()")
    public void star(){
    }
    @AfterThrowing("pt1()")
    public void afterth(){
        System.out.println("出错了");
        sqlSession.rollback();
    }
}
