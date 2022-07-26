package cn.lnd.tacocloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 22:41
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * 当监听到了请求地址为 "/" 时，将请求转发到 "home" 视图上，即 "/templates/home.html"
         */
        registry.addViewController("/").setViewName("home");
    }
}
