package cn.lnd.tacocloud.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Author lnd
 * @Description 墨西哥鸡肉卷的实体类
 * @Date 2022/7/23 19:37
 */
@Data
public class Taco {
    /**
     * 仅在数据库插入数据时使用，所以用户可以不用传入，由后台自动生成，自然也不需要进行参数校验
     */
    private Long id;
    private Date createTime;

    /**
     * 鸡肉卷的名字
     */
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 character long")
    private String name;

    /**
     * 鸡肉卷的配料表
     */
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;
}
