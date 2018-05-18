package UserInterface.Controllers;

import static UserInterface.Insertion.InsertionFlag.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import core.WireworldSimulation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


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
    @FXML
    private MenuItem notRight;
    @FXML
    private MenuItem notTop;
    @FXML
    private MenuItem notBottom;
    @FXML
    private MenuItem notLeft;
    
    private GameGrid game;
    private WireworldSimulation simulation;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader botMenu = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/BottomMenu.fxml"));
        GridPane menu = null;
        try {
            menu = botMenu.load();

        } catch(IOException e){
            e.printStackTrace();
        }
        String css = SimulationController.class.getResource("/UserInterface/css/menu.css").toExternalForm();
        wireMenu.getStylesheets().add(css);
        wireMenu.setCenter(menu);

        game = new GameGrid();
        mediumGrid.setSelected(true);
        wireDisplay.setCenter(game.fillGrid());

        // initializing simulation with default values
        simulation = new WireworldSimulation(0, 0.2, this.getGame());

        SimulationController menuController = botMenu.getController();
        menuController.loadSimulation(simulation);


    }

    @FXML
    private void openFile(ActionEvent event) {
        OpenFileController openFileController = new OpenFileController(game, stage);
    }

    @FXML
    private void saveFile(ActionEvent event) {
        SaveFileController saveFileController = new SaveFileController(game, stage);
    }

    @FXML
    private void placeAndTop(ActionEvent event) {
        game.setInsertionFlag(AND_TOP);
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
    private void placeNotTop(ActionEvent event) {
        game.setInsertionFlag(NOT_TOP);
    }

    @FXML
    private void placeNotBottom(ActionEvent event) {
        game.setInsertionFlag(NOT_BOT);
    }

    @FXML
    private void placeNotLeft(ActionEvent event) {
        game.setInsertionFlag(NOT_LEFT);
    }

    @FXML
    private void placeNotRight(ActionEvent event) {
        game.setInsertionFlag(NOT_RIGHT);
    }

    @FXML
    private void showHelp(ActionEvent event) {
        HelpController helpController = new HelpController();
        helpController.display("Help");
    }

    @FXML
    private void clearGrid(ActionEvent event) {
        game.clearGrid();
        simulation.clearBoard();
    }

    @FXML
    private void setSmallGrid(ActionEvent event) {
        if(smallGrid.isSelected() && !mediumGrid.isSelected() && !largeGrid.isSelected()){
            setMenuItemGridSizeSelection(true, false, false);
        } else {
            setMenuItemGridSizeSelection(true, false, false);
            reloadDisplayedGrid(40);
        }
        reloadSimulationForNewGrid();
    }

    @FXML
    private void setMediumGrid(ActionEvent event) {
        if(mediumGrid.isSelected() && !largeGrid.isSelected() && !smallGrid.isSelected()){
            setMenuItemGridSizeSelection(false, true, false);
        } else {
            setMenuItemGridSizeSelection(false, true, false);
            reloadDisplayedGrid(20);
        }
        reloadSimulationForNewGrid();
    }

    @FXML
    private void setLargeGrid(ActionEvent event) {
        if(largeGrid.isSelected() && !mediumGrid.isSelected() && !smallGrid.isSelected()){
            setMenuItemGridSizeSelection(false, false, true);
        } else {
            setMenuItemGridSizeSelection(false, false, true);
            reloadDisplayedGrid(10);
        }
        reloadSimulationForNewGrid();

    }

    public GameGrid getGame() {
        return game;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    private void setMenuItemGridSizeSelection(boolean small, boolean medium, boolean large){
            smallGrid.setSelected(small);
            mediumGrid.setSelected(medium);
            largeGrid.setSelected(large);
    }
    
    private void reloadSimulationForNewGrid(){
        simulation.pause();
        simulation.setNewGrid(game);
        simulation.initializeBoardFromGrid();
    }
    
    private void reloadDisplayedGrid(int size){
        GameGrid newGame = new GameGrid(size);
        wireDisplay.getChildren().clear();
        game = newGame;
        wireDisplay.setCenter(game.fillGrid());
    }

    /* Draw conductor using mouse drag with CTRL */
    @FXML
    private void mouseDraggedDraw(MouseEvent event) {
        if(event.isPrimaryButtonDown() && event.isControlDown()){
            if(event.getX() >= 0 && event.getX() <= game.getWidth() && event.getY() >= 0 && event.getY() <= game.getHeight()){
                try{
                    int tileXCoordinate = (int)event.getX()/game.getTileSize();
                    int tileYCoordinate = (int)event.getY()/game.getTileSize();
                    game.changeState(tileXCoordinate, tileYCoordinate, 1);
                } catch (ArrayIndexOutOfBoundsException e){ /* Prevent drawning when user mouse drag not on the grid */
                    System.out.println("There is no Tile to change.");
                }
            }
        }
    }
}