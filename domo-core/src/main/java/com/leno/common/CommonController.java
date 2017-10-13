package com.leno.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by XianGuo
 * Date: 2017-10-12 19:34
 * 通用的控制器
 */
@Controller
public class CommonController {

    /**
     * 首页
     */
    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String index(){
        if(true){
            throw  new RuntimeException("随便的异常");
        }
        return "index";
    }


    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(){
        return "login";
    }
}
