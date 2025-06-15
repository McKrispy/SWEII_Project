package DAO;

import entity.Recipe;
import java.util.List;

/**
 * 这是食谱数据访问对象的接口。
 * 它定义了所有与食谱数据相关的操作，将业务逻辑与具体的数据库实现解耦。
 */
public interface RecipeDAO {

    /**
     * 从数据源获取所有食谱的列表。
     * @return 包含所有食谱的List，如果没有则返回空列表。
     */
    List<Recipe> getAllRecipes();

    /**
     * 根据名称模糊搜索食谱。
     * @param name 要搜索的食谱名称关键字。
     * @return 匹配搜索条件的食谱列表。
     */
    List<Recipe> searchRecipesByName(String name);

    /**
     * 根据ID获取一个特定的食谱。
     * @param id 食谱的唯一ID。
     * @return 找到的Recipe对象，如果找不到则返回null。
     */
    Recipe getRecipeById(int id);

    /**
     * 保存一个新的食谱到数据源。
     * @param recipe 要保存的Recipe对象。
     * @return 如果保存成功返回true，否则返回false。
     */
    boolean saveRecipe(Recipe recipe);

    // 其他需要的方法，如 updateRecipe, deleteRecipe 等可以后续添加...
}