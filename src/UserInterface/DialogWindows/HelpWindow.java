package UserInterface.DialogWindows;

import UserInterface.Controllers.SimulationController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


import javafx.stage.Modality;
import javafx.stage.Stage;


public class HelpWindow extends PopUpWindow{
    
    @Override
    public void display(){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Help");
        window.getIcons().add(new Image("UserInterface/launcher.png"));
        
        StringBuilder help = new StringBuilder();
        prepareHelpMessage(help);
        
        Label helpLabel = new Label();
        helpLabel.setText(help.toString());
        
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
        layout.setPrefSize(600, 400);
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
    
    private void prepareHelpMessage(StringBuilder help){
        help.append("How to use the program\n\n");
        
        help.append("You can create your own circuit using mouse buttons:\n");
        help.append(">Press LMB to set Conductor or clear tile.\n>Press RMB to set Electron's head, Electron's tail or clear tile.\n\n");
        
        help.append("Moreover, you can draw circuit with mouse dragging (move mouse while LMB is pressed):\n");
        help.append(">Hold CTRL down to draw Conductor.\n>Hold SHIFT down to clear grid.\n\n");
        
        help.append("While inserting logic gates you are informed whether you can place logic gate or not by simple\nhighlght on gird.\n");
        help.append(">Press LMB to insert logic gate if it is possible. Program will wait untill you choose correct tile.\n");
        help.append(">Press RMB to cancel inserting logic gate.");
    }

}
