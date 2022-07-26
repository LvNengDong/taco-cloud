package cn.lnd.tacocloud.controller;

import cn.lnd.tacocloud.domain.Ingredient;
import cn.lnd.tacocloud.domain.Taco;
import cn.lnd.tacocloud.repository.IngredientRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lnd
 * @Description 展示可供选择的配料列表
 * @Date 2022/7/23 19:05
 */
@RequestMapping("/design")
@Slf4j
@RestController
public class DesignTacoController {

    @Autowired
    private IngredientRepository ingredientRepo;


    @GetMapping
    public HashMap<String, List<Ingredient>> showDesignForm(Model model) {
        // 所有的配料（TODO：从数据库中获取）
        ArrayList<Ingredient> ingredients = Lists.newArrayList();
        ingredientRepo.findAll().forEach(e -> ingredients.add(e));
        //ArrayList<Ingredient> ingredients = Lists.newArrayList(
        //        new Ingredient("1", "普通面饼", Ingredient.Type.WRAP),
        //        new Ingredient("2", "薄脆饼", Ingredient.Type.WRAP),
        //        new Ingredient("3", "牛肉", Ingredient.Type.PROTEIN),
        //        new Ingredient("4", "鸡肉", Ingredient.Type.PROTEIN),
        //        new Ingredient("5", "生菜", Ingredient.Type.VEGGIES),
        //        new Ingredient("6", "圆心菜", Ingredient.Type.VEGGIES),
        //        new Ingredient("7", "蓝纹奶酪", Ingredient.Type.CHEESE),
        //        new Ingredient("8", "普通奶酪", Ingredient.Type.CHEESE),
        //        new Ingredient("9", "沙拉酱", Ingredient.Type.SAUCE),
        //        new Ingredient("10", "番茄酱", Ingredient.Type.SAUCE)
        //);

        // 按照 Type 分类
        Ingredient.Type[] types = Ingredient.Type.values();
        HashMap<String, List<Ingredient>> map = Maps.newHashMap();
        for (Ingredient.Type type : types) {
            List<Ingredient> ingredientListByType = filterByType(ingredients, type);
            map.put(type.toString().toLowerCase(), ingredientListByType);
        }

        return map;
    }

    /**
     * 当表单提交的时候，表单中的输入域会绑定要 Taco 对象的属性中，该对象会以参数的形式传递给 processDesign
     *
     * @param design
     * @return
     */
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()){
            return errors.toString();
        }

        log.info("processDesign: " + design);
        // TODO 将用户提交的数据持久化到数据库中
        return "OK";
        /*
            TODO：订单提交成功后，重定向到一个订单表单页面
                1、如果是前后端不分离的项目，由后端通过重定向 redirect:/orders/current 转到 /orders/current 接口中；
                2、如果是前后端分离的项目，由前端继续请求 /orders/current 接口。
        */
    }


    /**
     * 将所有 ingredients 数据分类保存
     *
     * @param ingredients
     * @param type
     * @return
     */
    private List<Ingredient> filterByType(ArrayList<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> list = ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
        return list;
    }
}
