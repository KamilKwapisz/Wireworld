package UserInterface.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import core.Board;
import core.Cell;
import core.WireworldSimulation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
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
    @FXML
    private MenuItem fileClear;
    @FXML
    private CheckMenuItem smallGrid;
    @FXML
    private CheckMenuItem mediumGrid;
    @FXML
    private CheckMenuItem largeGrid;
    
    private GameGrid game;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader botMenu = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/BottomMenu.fxml"));
        GridPane menu = null;
	try {
        menu = botMenu.load();
        
        } catch(IOException e){
            e.printStackTrace();
        }
        String css = MenuController.class.getResource("/UserInterface/css/menu.css").toExternalForm();
        wireMenu.getStylesheets().add(css);
        wireMenu.setCenter(menu);
        
        game = new GameGrid(20);
        mediumGrid.setSelected(true);
        wireDisplay.setCenter(game.createContent());
        //wireDisplay.getChildren().add(game.createContent());


    }    

    @FXML
    private void openFile(ActionEvent event) {
        OpenFileController openFileController = new OpenFileController(game);
    }

    @FXML
    private void saveFile(ActionEvent event) {
        SaveFileController saveFileController = new SaveFileController(game);
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
        HelpController helpController = new HelpController();
        helpController.display("Help");
    }

    @FXML
    private void clearGrid(ActionEvent event) {
        game.clearGrid();
    }

    @FXML
    private void setSmallGrid(ActionEvent event) {
        if(smallGrid.isSelected() && !mediumGrid.isSelected() && !largeGrid.isSelected()){
            smallGrid.setSelected(true);
            mediumGrid.setSelected(false);
            largeGrid.setSelected(false);
        } else {
            smallGrid.setSelected(true);
            mediumGrid.setSelected(false);
            largeGrid.setSelected(false);
            GameGrid small = new GameGrid(40);
            wireDisplay.getChildren().clear();
            game = small;
            wireDisplay.setCenter(game.createContent());
        }
    }

    @FXML
    private void setMediumGrid(ActionEvent event) {
        if(mediumGrid.isSelected() && !largeGrid.isSelected() && !smallGrid.isSelected()){
            smallGrid.setSelected(false);
            mediumGrid.setSelected(true);
            largeGrid.setSelected(false);
        } else {
            smallGrid.setSelected(false);
            mediumGrid.setSelected(true);
            largeGrid.setSelected(false);
            GameGrid medium = new GameGrid(20);
            wireDisplay.getChildren().clear();
            game = medium;
            wireDisplay.setCenter(game.createContent());
            
        }
    }

    @FXML
    private void setLargeGrid(ActionEvent event) {
        if(largeGrid.isSelected() && !mediumGrid.isSelected() && !smallGrid.isSelected()){
            smallGrid.setSelected(false);
            mediumGrid.setSelected(false);
            largeGrid.setSelected(true);
        } else {
            smallGrid.setSelected(false);
            mediumGrid.setSelected(false);
            largeGrid.setSelected(true);
            GameGrid large = new GameGrid(10);
            wireDisplay.getChildren().clear();
            game = large;
            wireDisplay.setCenter(game.createContent());
        }
    }

    public GameGrid getGame() {
        return game;
    }
//

    
}
