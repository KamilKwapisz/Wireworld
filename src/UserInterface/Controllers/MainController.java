package UserInterface.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class MainController implements Initializable {

    @FXML
    private MenuItem fileOpen;
    @FXML
    private MenuItem fileSave;
    @FXML
    private MenuItem andTop;
    @FXML
    private MenuItem andBottom;
    @FXML
    private MenuItem andLeft;
    @FXML
    private MenuItem andRight;
    @FXML
    private MenuItem orTop;
    @FXML
    private MenuItem orBottom;
    @FXML
    private MenuItem orLeft;
    @FXML
    private MenuItem orRight;
    @FXML
    private MenuItem xorTop;
    @FXML
    private MenuItem xorBottom;
    @FXML
    private MenuItem xorLeft;
    @FXML
    private MenuItem xorRight;
    @FXML
    private MenuItem nandTop;
    @FXML
    private MenuItem nandBottom;
    @FXML
    private MenuItem nandLeft;
    @FXML
    private MenuItem nandRight;
    @FXML
    private MenuItem helpMenu;
    @FXML
    private BorderPane wireDisplay;
    @FXML
    private BorderPane wireMenu;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader botMenu = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/BottomMenu.fxml"));
        GridPane menu = null;
	try {
        menu = botMenu.load();
        
        } catch(IOException e){
            e.printStackTrace();
        }
        wireMenu.setCenter(menu);
        
 
    }    

    @FXML
    private void openFile(ActionEvent event) {
    }

    @FXML
    private void saveFile(ActionEvent event) {
    }

    @FXML
    private void placeAndTop(ActionEvent event) {
    }

    @FXML
    private void placeAndBottom(ActionEvent event) {
    }

    @FXML
    private void placeAndLeft(ActionEvent event) {
    }

    @FXML
    private void placeAndRight(ActionEvent event) {
    }

    @FXML
    private void placeOrTop(ActionEvent event) {
    }

    @FXML
    private void placeOrBottom(ActionEvent event) {
    }

    @FXML
    private void placeOrLeft(ActionEvent event) {
    }

    @FXML
    private void placeOrRight(ActionEvent event) {
    }

    @FXML
    private void placeXorTop(ActionEvent event) {
    }

    @FXML
    private void placeXorBottom(ActionEvent event) {
    }

    @FXML
    private void placeXorLeft(ActionEvent event) {
    }

    @FXML
    private void placeXorRight(ActionEvent event) {
    }

    @FXML
    private void placeNandTop(ActionEvent event) {
    }

    @FXML
    private void placeNandBottom(ActionEvent event) {
    }

    @FXML
    private void placeNandLeft(ActionEvent event) {
    }

    @FXML
    private void placeNandRight(ActionEvent event) {
    }

    @FXML
    private void showHelp(ActionEvent event) {
    }
    
}
