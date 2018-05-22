package UserInterface.Controllers;

import UserInterface.Insertion.InsertionFlag;
import static UserInterface.Insertion.InsertionFlag.*;
import UserInterface.Insertion.LogicGate;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    private InsertionFlag insertionFlag;
    private Stage stage;
    private MediaPlayer musicPlayer;
    private LogicGate logicGate;

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

        SimulationController simulationController = botMenu.getController();
        simulationController.loadSimulation(simulation);
        
        Media song = new Media(getClass().getResource("song.mp3").toExternalForm());
        musicPlayer = new MediaPlayer(song);
        musicPlayer.setAutoPlay(true);
        musicPlayer.setVolume(0.5);
        musicPlayer.setOnEndOfMedia(() -> {
            musicPlayer.seek(Duration.ZERO);
        });
        musicPlayer.pause();
        simulationController.loadMediaPlayer(musicPlayer);
        logicGate = new LogicGate(game.getGrid());
        insertionFlag = NORMAL;

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
        this.insertionFlag = AND_TOP;
        game.setInsertionFlag(AND_TOP);
    }

    @FXML
    private void placeAndBottom(ActionEvent event) {
        this.insertionFlag = AND_BOT;
        game.setInsertionFlag(AND_BOT);
    }

    @FXML
    private void placeAndLeft(ActionEvent event) {
        this.insertionFlag = AND_LEFT;
        game.setInsertionFlag(AND_LEFT);
    }

    @FXML
    private void placeAndRight(ActionEvent event) {
        this.insertionFlag = AND_RIGHT;
        game.setInsertionFlag(AND_RIGHT);
    }

    @FXML
    private void placeOrTop(ActionEvent event) {
        this.insertionFlag = OR_TOP;
        game.setInsertionFlag(OR_TOP);
    }

    @FXML
    private void placeOrBottom(ActionEvent event) {
        this.insertionFlag = OR_BOT;
        game.setInsertionFlag(OR_BOT);
    }

    @FXML
    private void placeOrLeft(ActionEvent event) {
        this.insertionFlag = OR_LEFT;
        game.setInsertionFlag(OR_LEFT);
    }

    @FXML
    private void placeOrRight(ActionEvent event) {
        this.insertionFlag = OR_RIGHT;
        game.setInsertionFlag(OR_RIGHT);
    }

    @FXML
    private void placeXorTop(ActionEvent event) {
        this.insertionFlag = XOR_TOP;
        game.setInsertionFlag(XOR_TOP);
    }

    @FXML
    private void placeXorBottom(ActionEvent event) {
        this.insertionFlag = XOR_BOT;
        game.setInsertionFlag(XOR_BOT);
    }

    @FXML
    private void placeXorLeft(ActionEvent event) {
        this.insertionFlag = XOR_LEFT;
        game.setInsertionFlag(XOR_LEFT);
    }

    @FXML
    private void placeXorRight(ActionEvent event) {
        this.insertionFlag = XOR_RIGHT;
        game.setInsertionFlag(XOR_RIGHT);
    }

    @FXML
    private void placeNandTop(ActionEvent event) {
        this.insertionFlag = NAND_TOP;
        game.setInsertionFlag(NAND_TOP);
    }

    @FXML
    private void placeNandBottom(ActionEvent event) {
        this.insertionFlag = NAND_BOT;
        game.setInsertionFlag(NAND_BOT);
    }

    @FXML
    private void placeNandLeft(ActionEvent event) {
        this.insertionFlag = NAND_LEFT;
        game.setInsertionFlag(NAND_LEFT);
    }

    @FXML
    private void placeNandRight(ActionEvent event) {
        this.insertionFlag = NAND_RIGHT;
        game.setInsertionFlag(NAND_RIGHT);
    }

    @FXML
    private void placeNotTop(ActionEvent event) {
        this.insertionFlag = NOT_TOP;
        game.setInsertionFlag(NOT_TOP);
    }

    @FXML
    private void placeNotBottom(ActionEvent event) {
        this.insertionFlag = NOT_BOT;
        game.setInsertionFlag(NOT_BOT);
    }

    @FXML
    private void placeNotLeft(ActionEvent event) {
        this.insertionFlag = NOT_LEFT;
        game.setInsertionFlag(NOT_LEFT);
    }

    @FXML
    private void placeNotRight(ActionEvent event) {
        this.insertionFlag = NOT_RIGHT;
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
        simulation.pause();
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
        simulation.pause();
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
        simulation.pause();
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
        if(simulation.getCurrentGenerationNumber() == simulation.getNumberOfIterations()){
            simulation.runSimulation();
        }
        musicPlayer.pause();
        simulation.pause();
        simulation.setNewGrid(game);

    }
    
    private void reloadDisplayedGrid(int size){
        GameGrid newGame = new GameGrid(size);
        wireDisplay.getChildren().clear();
        game = newGame;
        logicGate = new LogicGate(game.getGrid());
        insertionFlag = NORMAL;
        wireDisplay.setCenter(game.fillGrid());
    }

    /* Draw conductor using mouse drag with CTRL */
    @FXML
    private void mouseDraggedDraw(MouseEvent event) {
        if(event.isPrimaryButtonDown() && event.isControlDown()){
            dragChangeState(event, 1);
        } else if(event.isPrimaryButtonDown() && event.isShiftDown()){
            dragChangeState(event, 0);
        }
    }
    
    private void dragChangeState(MouseEvent event, int state){
        if(event.getX() >= 0 && event.getX() <= game.getWidth() && event.getY() >= 0 && event.getY() <= game.getHeight()){
                try{
                    int tileXCoordinate = (int)event.getX()/game.getTileSize();
                    int tileYCoordinate = (int)event.getY()/game.getTileSize();
                    game.changeState(tileXCoordinate, tileYCoordinate, state);
                } catch (ArrayIndexOutOfBoundsException e){ /* Prevent drawning when user mouse drag not on the grid */
                    System.out.println("There is no Tile to change.");
                }
        }
    }

    @FXML
    private void mouseChangeState(MouseEvent event) {
        int tileXCoordinate = (int) event.getX() / game.getTileSize();
        int tileYCoordinate = (int) event.getY() / game.getTileSize();

        if (insertionFlag == NORMAL) {
            if (event.isPrimaryButtonDown()) {
                if (game.getGridState(tileXCoordinate, tileYCoordinate) == 1) {
                    game.changeState(tileXCoordinate, tileYCoordinate, 0);
                } else {
                    game.changeState(tileXCoordinate, tileYCoordinate, 1);
                }
            } else if (event.isSecondaryButtonDown()) {
                if (game.getGridState(tileXCoordinate, tileYCoordinate) == 2) {
                    game.changeState(tileXCoordinate, tileYCoordinate, 0);
                } else if (game.getGridState(tileXCoordinate, tileYCoordinate) == 3) {
                    game.changeState(tileXCoordinate, tileYCoordinate, 2);
                } else {
                    game.changeState(tileXCoordinate, tileYCoordinate, 3);
                }
            }
        } else if (insertionFlag == AND_TOP) {
            boolean isPossible = tileXCoordinate >= 3 && tileXCoordinate <= game.getXTiles() - 6 && tileYCoordinate >= 17;
            andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == AND_BOT) {
            boolean isPossible = tileXCoordinate >= 5 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate <= game.getYTiles() - 18;
            andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == AND_LEFT) {
            boolean isPossible = tileXCoordinate >= 17 && tileYCoordinate >= 5 && tileYCoordinate <= game.getYTiles() - 4;
            andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == AND_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 18 && tileYCoordinate >= 3 && tileYCoordinate <= game.getYTiles() - 6;
            andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == OR_TOP) {
            boolean isPossible = tileXCoordinate >= 1 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate >= 8;
            orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == OR_BOT) {
            boolean isPossible = tileXCoordinate >= 3 && tileXCoordinate <= game.getXTiles() - 2 && tileYCoordinate <= game.getYTiles() - 9;
            orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == OR_LEFT) {
            boolean isPossible = tileXCoordinate >= 8 && tileYCoordinate >= 3 && tileYCoordinate <= game.getYTiles() - 2;
            orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == OR_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 9 && tileYCoordinate >= 1 && tileYCoordinate <= game.getYTiles() - 4;
            orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == XOR_TOP) {
            boolean isPossible = tileXCoordinate >= 2 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate >= 10;
            xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == XOR_BOT) {
            boolean isPossible = tileXCoordinate >= 4 && tileXCoordinate <= game.getXTiles() - 3 && tileYCoordinate <= game.getYTiles() - 11;
            xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == XOR_LEFT) {
            boolean isPossible = tileXCoordinate >= 10 && tileYCoordinate >= 4 && tileYCoordinate <= game.getYTiles() - 3;
            xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == XOR_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 11 && tileYCoordinate >= 2 && tileYCoordinate <= game.getYTiles() - 5;
            xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NAND_TOP) {
            boolean isPossible = tileXCoordinate >= 5 && tileXCoordinate <= game.getXTiles() - 8 && tileYCoordinate >= 13;
            nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NAND_BOT) {
            boolean isPossible = tileXCoordinate >= 7 && tileXCoordinate <= game.getXTiles() - 6 && tileYCoordinate <= game.getYTiles() - 14;
            nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NAND_LEFT) {
            boolean isPossible = tileXCoordinate >= 13 && tileYCoordinate >= 7 && tileYCoordinate <= game.getYTiles() - 6;
            nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NAND_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 14 && tileYCoordinate >= 5 && tileYCoordinate <= game.getYTiles() - 8;
            nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NOT_TOP) {
            boolean isPossible = tileXCoordinate >= 2 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate >= 11;
            notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NOT_BOT) {
            boolean isPossible = tileXCoordinate >= 2 && tileXCoordinate <= game.getXTiles() - 3 && tileYCoordinate <= game.getYTiles() - 12;
            notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NOT_LEFT) {
            boolean isPossible = tileXCoordinate >= 11 && tileYCoordinate >= 2 && tileYCoordinate <= game.getYTiles() - 3;
            notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (insertionFlag == NOT_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 12 && tileYCoordinate >= 2 && tileYCoordinate <= game.getYTiles() - 4;
            notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        }
    }

    private void insertAnd(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertAnd();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void insertOr(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertOr();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void insertXor(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertXor();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void insertNand(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertNand();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void insertNot(int x, int y) {
        logicGate.setProperties(x, y, insertionFlag);
        logicGate.insertNot();
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void cancelInserting(int x, int y) {
        Rectangle border = game.getRectangle(x, y);
        border.setFill(game.getColor(x, y));
        insertionFlag = NORMAL;
        game.setInsertionFlag(NORMAL);
    }

    private void andMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertAnd(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    private void orMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertOr(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    private void xorMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertXor(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    private void nandMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertNand(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }

    private void notMouseControl(MouseEvent event, boolean isPossible, int x, int y) {
        if (event.isPrimaryButtonDown()) {
            if (isPossible) {
                insertNot(x, y);
            }
        } else if (event.isSecondaryButtonDown()) {
            cancelInserting(x, y);
        }
    }
    
}