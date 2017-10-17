package com.leno.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/index.html")
    public String indexCus() {
        return "index";
    }
}
