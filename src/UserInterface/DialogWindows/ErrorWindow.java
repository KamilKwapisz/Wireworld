package UserInterface.DialogWindows;

import UserInterface.Controllers.SimulationController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorWindow extends PopUpWindow{
    private String errorMessage;
    
    public ErrorWindow(String errorMessage){
        this.errorMessage = errorMessage;
    }
    
    @Override
    public void display() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        window.getIcons().add(new Image("UserInterface/css/error.png"));
        
        
        Label helpLabel = new Label();
        helpLabel.setText(errorMessage);
        
        Button closeButton = new Button("Close");
        closeButton.setId("closeButton");
        
        ImageView imageView = new ImageView("UserInterface/css/error.png");
        
        helpLabel.setAlignment(Pos.TOP_LEFT);
        AnchorPane.setTopAnchor(helpLabel, 25.0);
        AnchorPane.setLeftAnchor(helpLabel, 40.0);
        AnchorPane.setRightAnchor(helpLabel, 25.0);
        
        AnchorPane.setLeftAnchor(closeButton, 140.0);
        AnchorPane.setRightAnchor(closeButton, 140.0);
        AnchorPane.setBottomAnchor(closeButton, 25.0);
        
        AnchorPane.setLeftAnchor(imageView, 5.0);
        AnchorPane.setTopAnchor(imageView, 25.0);
        
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(390, 120);
        layout.setId("layout");
        String css = SimulationController.class.getResource("/UserInterface/css/menu.css").toExternalForm();
        layout.getStylesheets().add(css);
        layout.getChildren().addAll(helpLabel, closeButton, imageView);

        closeButton.setOnAction(e-> window.close());
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
    
    
    
}
