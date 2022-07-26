package cn.lnd.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author lnd
 * @Description 该类已经被废弃，被视图控制器所代替。详见{@link cn.lnd.tacocloud.config.WebConfig}
 * @Date 2022/7/23 17:19
 */
//@Controller   // 该类已经被废弃，被视图控制器所代替
public class HomeController {

    @GetMapping("/")
    public String home(){
        // 将 "/" 请求转发到视图名为 home 的页面
        // home 是视图的逻辑名称，再加上 "/templates/"前缀和 ".html" 后缀，最终形成的模板路径是 "/templates/home.html"
        return "home";
    }
}
