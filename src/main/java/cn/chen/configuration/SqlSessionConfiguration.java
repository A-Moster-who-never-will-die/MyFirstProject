package cn.chen.configuration;



import cn.chen.dao.AccountDao;
import cn.chen.dao.ExceptionDao;
import cn.chen.dao.HeadDao;
import cn.chen.dao.NameDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 *将SqlSession储存到Spring容器中
 */
@Configuration
@ComponentScan(basePackages = {"cn.chen"})
public class SqlSessionConfiguration {

    @Bean("sqlSession")
    public SqlSession getSqlSession() throws IOException {
            SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMap.xml"));
            SqlSession sqlSession=sf.openSession();
            return sqlSession;
    }
    @Bean("accountDao")
    public AccountDao getAccountDao(SqlSession sqlSession){
        return sqlSession.getMapper(AccountDao.class);

    }
    @Bean("exceptionDao")
    public ExceptionDao getExceptionDao(SqlSession sqlSession){
        return sqlSession.getMapper(ExceptionDao.class);
    }
    @Bean("nameDao")
    public NameDao getNameDao(SqlSession sqlSession){return sqlSession.getMapper(NameDao.class);}
    @Bean("headDao")
    public HeadDao getHeadDao(SqlSession sqlSession){return sqlSession.getMapper(HeadDao.class); }
}
