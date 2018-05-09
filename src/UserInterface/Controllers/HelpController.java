package UserInterface.Controllers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import javafx.stage.Modality;
import javafx.stage.Stage;


public class HelpController {
   
    public void display(String title){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.getIcons().add(new Image("UserInterface/launcher.png"));
        
        
        String help = "Help" + "\nYou can create your own circuit using mouse buttons:"
                + "\nPress LMB to set Conductor or clear tile"
                + "\nPress RMB to set Electron's head, Electron's tail or clear tile";
        
        Label helpLabel = new Label();
        helpLabel.setText(help);
        
        Button closeButton = new Button("Close");
        closeButton.setId("closeButton");
        
        helpLabel.setAlignment(Pos.TOP_LEFT);
        AnchorPane.setTopAnchor(helpLabel, 25.0);
        AnchorPane.setLeftAnchor(helpLabel, 25.0);
        AnchorPane.setRightAnchor(helpLabel, 25.0);
        
        AnchorPane.setLeftAnchor(closeButton, 262.0);
        AnchorPane.setRightAnchor(closeButton, 262.0);
        AnchorPane.setBottomAnchor(closeButton, 25.0);
        
        AnchorPane layout = new AnchorPane();
        layout.setPrefSize(600, 600);
        layout.setId("layout");
        String css = SimulationController.class.getResource("/UserInterface/css/menu.css").toExternalForm();
        layout.getStylesheets().add(css);
        layout.getChildren().addAll(helpLabel, closeButton);

        
        closeButton.setOnAction(e-> window.close());
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.setResizable(false);
        window.show();
        
    }

}
