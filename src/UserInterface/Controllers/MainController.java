package UserInterface.Controllers;

import static UserInterface.Insertion.InsertionFlag.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import core.Board;
import core.Cell;
import core.WireworldSimulation;
import javafx.application.Platform;
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
    private WireworldSimulation simulation;
    
    
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
        
        game = new GameGrid();
        mediumGrid.setSelected(true);
        wireDisplay.setCenter(game.createContent());
        //wireDisplay.getChildren().add(game.createContent());

        // initializing simulation with default values
        simulation = new WireworldSimulation(0, 0.5, this.getGame());

        MenuController menuController = botMenu.getController();
        menuController.loadSimulation(simulation);


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

        game.setInsertionFlag(AND_TOP);
        

        simulation.runSimulation();
//        try{
////            Thread.sleep(1000);
////            simulation.pause();
////            Thread.sleep(1500);
////            simulation.unpause();
////        } catch (Exception e){
////
////        }

    }

    @FXML
    private void placeAndBottom(ActionEvent event) {
        game.setInsertionFlag(AND_BOT);
    }

    @FXML
    private void placeAndLeft(ActionEvent event) {
        game.setInsertionFlag(AND_LEFT);
    }

    @FXML
    private void placeAndRight(ActionEvent event) {
        game.setInsertionFlag(AND_RIGHT);
    }

    @FXML
    private void placeOrTop(ActionEvent event) {
        game.setInsertionFlag(OR_TOP);
    }

    @FXML
    private void placeOrBottom(ActionEvent event) {
        game.setInsertionFlag(OR_BOT);
    }

    @FXML
    private void placeOrLeft(ActionEvent event) {
        game.setInsertionFlag(OR_LEFT);
    }

    @FXML
    private void placeOrRight(ActionEvent event) {
        game.setInsertionFlag(OR_RIGHT);
    }

    @FXML
    private void placeXorTop(ActionEvent event) {
        game.setInsertionFlag(XOR_TOP);
    }

    @FXML
    private void placeXorBottom(ActionEvent event) {
        game.setInsertionFlag(XOR_BOT);
    }

    @FXML
    private void placeXorLeft(ActionEvent event) {
        game.setInsertionFlag(XOR_LEFT);
    }

    @FXML
    private void placeXorRight(ActionEvent event) {
        game.setInsertionFlag(XOR_RIGHT);
    }

    @FXML
    private void placeNandTop(ActionEvent event) {
        game.setInsertionFlag(NAND_TOP);
    }

    @FXML
    private void placeNandBottom(ActionEvent event) {
        game.setInsertionFlag(NAND_BOT);
    }

    @FXML
    private void placeNandLeft(ActionEvent event) {
        game.setInsertionFlag(NAND_LEFT);
    }

    @FXML
    private void placeNandRight(ActionEvent event) {
        game.setInsertionFlag(NAND_RIGHT);
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
        simulation.initializeBoardFromGrid();
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
        simulation.initializeBoardFromGrid();
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
        simulation.initializeBoardFromGrid();
        simulation.getCellsFromGrid();
    }

    public GameGrid getGame() {
        return game;
    }
//

    
}
