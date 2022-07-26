package cn.lnd.tacocloud.repository;

import cn.lnd.tacocloud.domain.Ingredient;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 23:15
 */
public interface IngredientRepository {

    /**
     * 查询所有的配料信息
     * @return
     */
    Iterable<Ingredient> findAll();

    /**
     * 根据id查询配料信息
     * @param id
     * @return
     */
    Ingredient findOne(String id);

    /**
     * 保存配料信息
     * @param ingredient
     * @return
     */
    void save(Ingredient ingredient);
}
