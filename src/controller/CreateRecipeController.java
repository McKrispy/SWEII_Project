package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateRecipeController {

    @FXML
    private TextField recipeNameField;

    @FXML
    private TextField servingsField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private VBox ingredientsBox;

    @FXML
    private VBox instructionsBox;

    @FXML
    private void handleAddIngredient() {
        HBox ingredientRow = new HBox(5);
        TextField weightField = new TextField();
        weightField.setPromptText("Weight");

        TextField unitField = new TextField();
        unitField.setPromptText("Unit");

        TextField nameField = new TextField();
        nameField.setPromptText("Ingredient Name");

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> ingredientsBox.getChildren().remove(ingredientRow));

        ingredientRow.getChildren().addAll(weightField, unitField, nameField, deleteButton);
        ingredientsBox.getChildren().add(ingredientRow);
    }

    @FXML
    private void handleAddInstruction() {
        HBox stepRow = new HBox(5);
        TextField stepField = new TextField();
        stepField.setPromptText("Step");

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> instructionsBox.getChildren().remove(stepRow));

        stepRow.getChildren().addAll(stepField, deleteButton);
        instructionsBox.getChildren().add(stepRow);
    }

    @FXML
    private void handleSubmitRecipe() {
        String name = recipeNameField.getText();
        String servings = servingsField.getText();
        String description = descriptionArea.getText();

        // 你可以在这里添加逻辑来收集ingredients和instructions
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Recipe Submitted");
        alert.setHeaderText(null);
        alert.setContentText("Recipe \"" + name + "\" submitted successfully!");
        alert.showAndWait();
    }
}
