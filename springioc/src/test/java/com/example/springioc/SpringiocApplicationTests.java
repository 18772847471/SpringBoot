package com.example.springioc;

import com.example.springioc.business.bean.Fox;
import com.example.springioc.business.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringiocApplicationTests {

    @Test
    void test() {
        ApplicationContext context =new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean(Fox.class));
    }

}
