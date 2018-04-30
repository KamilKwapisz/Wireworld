package UserInterface;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class WireWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/WireWorldLayout.fxml"));
	GridPane pane = loader.load();
	Scene scene = new Scene(pane);

        primaryStage.setTitle("WireWorld");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("UserInterface/launcher.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
