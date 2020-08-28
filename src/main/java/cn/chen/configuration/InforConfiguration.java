package cn.chen.configuration;

import org.apache.ibatis.io.Resources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.*;

@Configuration
@ComponentScan(basePackages = {"cn.chen.service"})
public class InforConfiguration {

}
