package com.irrt.spring.springduble;

import com.irrt.spring.springduble.service.CatSound;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.applet.AppletContext;

@SpringBootApplication
public class SpringdubleApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =  SpringApplication.run(SpringdubleApplication.class, args);
        CatSound catSound =(CatSound) ctx.getBean("catSound");
        System.out.println(catSound.sound());
    }

}
