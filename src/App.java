import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/MainView.fxml"));
        primaryStage.setTitle("数字食谱");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // 加上main方法
    public static void main(String[] args) {
        launch(args);
    }
}