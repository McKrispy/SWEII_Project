package controller;

import entity.Recipe; // 确保你的Recipe实体类在这个包路径下
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell; // 新增导入
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * 主视图的控制器。
 * 负责处理用户交互，如搜索和列表选择，并协调与后端服务的通信。
 */
public class MainViewController implements Initializable {

    // --- FXML UI Components ---
    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<Recipe> recipeListView;

    // --- 后端服务接口 (未来将替换为真实实现) ---
    // private RecipeDAO recipeDAO;

    /**
     * 当 FXML 文件加载完成，所有 @FXML 成员被注入后，此方法会自动调用。
     * 用于初始化视图，设置监听器和加载初始数据。
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("MainViewController is initializing...");
        
        // 在未来，这里会初始化真正的DAO实现
        // this.recipeDAO = new RecipeDAOImpl(); 

        // 1. 配置ListView如何显示Recipe对象
        setupListViewCellFactory();

        // 2. 配置ListView的项目选择事件
        setupListViewSelectionListener();

        // 3. 加载初始的食谱列表
        loadAllRecipes();
    }

    /**
     * 处理“搜索”按钮的点击事件。
     * 从文本框获取输入，并调用相应的数据加载方法。
     */
    @FXML
    private void handleSearchAction(ActionEvent event) {
        String searchText = searchTextField.getText().trim();

        if (searchText.isEmpty()) {
            // 如果搜索框为空，重新加载所有食谱
            loadAllRecipes();
        } else {
            // 否则，根据关键字进行搜索
            searchRecipes(searchText);
        }
    }

    // --- 数据加载与显示方法 ---

    /**
     * 加载并显示所有食谱。
     */
    private void loadAllRecipes() {
        System.out.println("Loading all recipes...");
        // 理想情况: List<Recipe> recipes = recipeDAO.getAllRecipes();
        
        // --- 模拟数据 ---
        ArrayList<Recipe> mockRecipes = new ArrayList<>();
        // 确保你的Recipe类有一个接收name和description的构造函数
        mockRecipes.add(new Recipe("Spaghetti Carbonara", "Classic Italian pasta dish."));
        mockRecipes.add(new Recipe("Chicken Curry", "Spicy and flavorful curry."));
        mockRecipes.add(new Recipe("Tiramisu", "Famous Italian coffee-flavored dessert."));
        // -----------------

        recipeListView.getItems().clear();
        recipeListView.getItems().addAll(mockRecipes);
    }

    /**
     * 根据名称搜索食谱并显示结果。
     */
    private void searchRecipes(String name) {
        System.out.println("Searching for recipes named: " + name);
        // 理想情况: List<Recipe> recipes = recipeDAO.searchRecipesByName(name);

        // --- 模拟数据 ---
        ArrayList<Recipe> mockResults = new ArrayList<>();
        if (name.equalsIgnoreCase("pasta")) { // 简单的模拟逻辑
             mockResults.add(new Recipe("Spaghetti Carbonara", "Classic Italian pasta dish."));
        } else {
             mockResults.add(new Recipe("Found: " + name, "This is a search result."));
        }
        // -----------------
        
        recipeListView.getItems().clear();
        recipeListView.getItems().addAll(mockResults);
    }


    // --- UI 配置辅助方法 ---

    /**
     * 设置 ListView 的 CellFactory。
     * 这决定了每个 Recipe 对象在列表中的显示方式（只显示名称）。
     */
    private void setupListViewCellFactory() {
        recipeListView.setCellFactory(param -> new ListCell<Recipe>() {
            @Override
            protected void updateItem(Recipe recipe, boolean empty) {
                super.updateItem(recipe, empty);

                if (empty || recipe == null || recipe.getName() == null) {
                    setText(null);
                } else {
                    setText(recipe.getName());
                }
            }
        });
    }

    /**
     * 为 ListView 添加选择监听器。
     * 当用户点击列表中的项目时触发。
     */
    private void setupListViewSelectionListener() {
        recipeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Recipe selectedRecipe = newValue;
                System.out.println("User selected recipe: " + selectedRecipe.getName());
    
                // TODO: 在这里实现导航到食谱详情页的逻辑
                // navigateToRecipeDetail(selectedRecipe); 
            }
        });
    }
}