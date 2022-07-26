package cn.lnd.tacocloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author lnd
 * @Description 定义taco配料
 * @Date 2022/7/23 18:59
 */
@Data
@AllArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    /**
     * 类型
     */
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
