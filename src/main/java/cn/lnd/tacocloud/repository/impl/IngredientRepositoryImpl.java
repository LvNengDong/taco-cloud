package cn.lnd.tacocloud.repository.impl;

import cn.lnd.tacocloud.domain.Ingredient;
import cn.lnd.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 23:18
 */
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Iterable<Ingredient> findAll() {
        List<Ingredient> ingredients = jdbc.query(
                "select id,name,type from Ingredient",
                this::mapRowToIngredient);
        return ingredients;
    }

    @Override
    public Ingredient findOne(String id) {
        Ingredient ingredient = jdbc.queryForObject(
                "select id,name,type from Ingredient where id=?",
                this::mapRowToIngredient, id);
        return ingredient;
    }

    @Override
    public void save(Ingredient ingredient) {
        jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
    }

    public Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type"))
        );
        return ingredient;
    }
}
