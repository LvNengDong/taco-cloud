package cn.lnd.tacocloud.domain;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 21:47
 */
@Data
public class Order {

    /**
     * 仅在数据库插入数据时使用，所以用户可以不用传入，由后台自动生成，自然也不需要进行参数校验
     */
    private Long id;
    private Date createTime;

    @NotBlank(message = "Name is required")
    private String name;

    /**
     * 地址相关属性：要求字段不为空（可以为null）
     */
    @NotBlank(message = "street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Zip is required")
    private String zip;

    /**
     * 支付相关属性
     */
    //@CreditCardNumber 注解已经被移除
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
}
