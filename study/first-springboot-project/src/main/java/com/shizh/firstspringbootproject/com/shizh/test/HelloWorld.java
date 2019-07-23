package com.shizh.firstspringbootproject.com.shizh.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorld
 * @Description TODO
 * @Author shizhonghuai
 * @Date 2019/7/23 22:54
 * @Version 1.0
 **/
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @RequestMapping("/sayHi")
    public String sayHi(){
        return "hello World,this is myFirst demo!";
    }
}
