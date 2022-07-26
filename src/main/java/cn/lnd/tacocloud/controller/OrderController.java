package cn.lnd.tacocloud.controller;

import cn.lnd.tacocloud.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 21:40
 */
@Slf4j
@RequestMapping("/orders")
@RestController
public class OrderController {

    /**
     * 获取订单信息
     *
     * @return
     */
    @GetMapping("/current")
    public String orderForm(String id){
        // TODO 从数据库中查询并返回订单信息
        return "orderInfo";
    }

    /**
     * 处理订单提交
     */
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors){
        // 校验表单输入
        if (errors.hasErrors()){
            return errors.toString();
        }
        // TODO 持久化
        return "OK";
    }
}
