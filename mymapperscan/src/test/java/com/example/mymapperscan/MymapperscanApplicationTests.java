package com.example.mymapperscan;

import com.example.mymapperscan.business.config.AppConfig;
import com.example.mymapperscan.business.mapper.MyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class MymapperscanApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
        MyMapper myMapper = context.getBean(MyMapper.class);
        myMapper.selectTest();

    }

}
