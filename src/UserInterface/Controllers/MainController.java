package UserInterface.Controllers;

import static UserInterface.Insertion.InsertionFlag.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import UserInterface.Insertion.InsertionFlag;
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
    private Stage stage;
    private MediaPlayer musicPlayer;
    private MouseStateChanger mouseStateChanger;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader botMenu = new FXMLLoader(this.getClass().getResource("/UserInterface/fxml/BottomMenu.fxml"));
        GridPane menu = null;
        try {
            menu = botMenu.load();

        } catch (IOException e) {
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
        mouseStateChanger = new MouseStateChanger(game);

    }

    @FXML
    private void openFile(ActionEvent event) {
        OpenFileController openFileController = new OpenFileController(game, stage);
    }

    @FXML
    private void saveFile(ActionEvent event) {
        SaveFileController saveFileController = new SaveFileController(game, stage);
    }

    private void setInsertionDetails(InsertionFlag insertionFlag){
        mouseStateChanger.setInsertionFlag(insertionFlag);
        game.setInsertionFlag(insertionFlag);
    }

    @FXML
    private void placeAndTop(ActionEvent event) {
        setInsertionDetails(AND_TOP);
    }

    @FXML
    private void placeAndBottom(ActionEvent event) {
        setInsertionDetails(AND_BOT);
    }

    @FXML
    private void placeAndLeft(ActionEvent event) {
        setInsertionDetails(AND_LEFT);
    }

    @FXML
    private void placeAndRight(ActionEvent event) {
        setInsertionDetails(AND_RIGHT);
    }

    @FXML
    private void placeOrTop(ActionEvent event) {
        setInsertionDetails(OR_TOP);
    }

    @FXML
    private void placeOrBottom(ActionEvent event) {
        setInsertionDetails(OR_BOT);
    }

    @FXML
    private void placeOrLeft(ActionEvent event) {
        setInsertionDetails(OR_LEFT);
    }

    @FXML
    private void placeOrRight(ActionEvent event) {
        setInsertionDetails(OR_RIGHT);
    }

    @FXML
    private void placeXorTop(ActionEvent event) {
        setInsertionDetails(XOR_TOP);
    }

    @FXML
    private void placeXorBottom(ActionEvent event) {
        setInsertionDetails(XOR_BOT);
    }

    @FXML
    private void placeXorLeft(ActionEvent event) {
        setInsertionDetails(XOR_LEFT);
    }

    @FXML
    private void placeXorRight(ActionEvent event) {
        setInsertionDetails(XOR_RIGHT);
    }

    @FXML
    private void placeNandTop(ActionEvent event) {
        setInsertionDetails(NAND_TOP);
    }

    @FXML
    private void placeNandBottom(ActionEvent event) {
        setInsertionDetails(NAND_BOT);
    }

    @FXML
    private void placeNandLeft(ActionEvent event) {
        setInsertionDetails(NAND_LEFT);
    }

    @FXML
    private void placeNandRight(ActionEvent event) {
        setInsertionDetails(NAND_RIGHT);
    }

    @FXML
    private void placeNotTop(ActionEvent event) {
        setInsertionDetails(NOT_TOP);
    }

    @FXML
    private void placeNotBottom(ActionEvent event) {
        setInsertionDetails(NOT_BOT);
    }

    @FXML
    private void placeNotLeft(ActionEvent event) {
        setInsertionDetails(NOT_LEFT);
    }

    @FXML
    private void placeNotRight(ActionEvent event) {
        setInsertionDetails(NOT_RIGHT);
    }

    @FXML
    private void showHelp(ActionEvent event) {
        PopUpWindow helpWindow = new HelpWindow();
        helpWindow.display();
    }

    @FXML
    private void clearGrid(ActionEvent event) {
        simulation.pause();
        game.clearGrid();
        simulation.clearBoard();
    }

    @FXML
    private void setSmallGrid(ActionEvent event) {
        simulation.pause();
        if (smallGrid.isSelected() && !mediumGrid.isSelected() && !largeGrid.isSelected()) {
            setMenuItemGridSizeSelection(true, false, false);
        } else {
            setMenuItemGridSizeSelection(true, false, false);
            reloadDisplayedGrid(40);
        }
        reloadSimulationForNewGrid();

        andTop.setVisible(false);
        andBottom.setVisible(false);
    }

    @FXML
    private void setMediumGrid(ActionEvent event) {
        simulation.pause();
        if (mediumGrid.isSelected() && !largeGrid.isSelected() && !smallGrid.isSelected()) {
            setMenuItemGridSizeSelection(false, true, false);
        } else {
            setMenuItemGridSizeSelection(false, true, false);
            reloadDisplayedGrid(20);
        }
        reloadSimulationForNewGrid();
        andTop.setVisible(true);
        andBottom.setVisible(true);
    }

    @FXML
    private void setLargeGrid(ActionEvent event) {
        simulation.pause();
        if (largeGrid.isSelected() && !mediumGrid.isSelected() && !smallGrid.isSelected()) {
            setMenuItemGridSizeSelection(false, false, true);
        } else {
            setMenuItemGridSizeSelection(false, false, true);
            reloadDisplayedGrid(10);
        }
        reloadSimulationForNewGrid();
        andTop.setVisible(true);
        andBottom.setVisible(true);

    }

    public GameGrid getGame() {
        return game;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void setMenuItemGridSizeSelection(boolean small, boolean medium, boolean large) {
        smallGrid.setSelected(small);
        mediumGrid.setSelected(medium);
        largeGrid.setSelected(large);
    }

    private void reloadSimulationForNewGrid() {
        if (simulation.getCurrentGenerationNumber() == simulation.getNumberOfIterations()) {
            simulation.runSimulation();
        }
        musicPlayer.pause();
        simulation.pause();
        simulation.setNewGrid(game);

    }

    private void reloadDisplayedGrid(int size) {
        GameGrid newGame = new GameGrid(size);
        wireDisplay.getChildren().clear();
        game = newGame;
        mouseStateChanger = new MouseStateChanger(game);
        wireDisplay.setCenter(game.fillGrid());
    }

    /* Draw conductor using mouse drag with CTRL */
    @FXML
    private void mouseDraggedDraw(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.isControlDown()) {
            dragChangeState(event, 1);
        } else if (event.isPrimaryButtonDown() && event.isShiftDown()) {
            dragChangeState(event, 0);
        }
    }

    private void dragChangeState(MouseEvent event, int state) {
        if (event.getX() >= 0 && event.getX() <= game.getWidth() && event.getY() >= 0 && event.getY() <= game.getHeight()) {
            try {
                int tileXCoordinate = (int) event.getX() / game.getTileSize();
                int tileYCoordinate = (int) event.getY() / game.getTileSize();
                game.changeState(tileXCoordinate, tileYCoordinate, state);
            } catch (ArrayIndexOutOfBoundsException e) {
                /* Prevent drawing when user mouse drag not on the grid */
                System.out.println("There is no Tile to change.");
            }
        }
    }

    @FXML
    private void mouseChangeState(MouseEvent event) {
        int tileXCoordinate = (int) event.getX() / game.getTileSize();
        int tileYCoordinate = (int) event.getY() / game.getTileSize();

        if (mouseStateChanger.getInsertionFlag() == NORMAL) {
            if (tileXCoordinate < game.getXTiles() && tileYCoordinate < game.getYTiles()) {
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
            }
        } else if (mouseStateChanger.getInsertionFlag() == AND_TOP) {
            boolean isPossible = tileXCoordinate >= 3 && tileXCoordinate <= game.getXTiles() - 6 && tileYCoordinate >= 17;
            mouseStateChanger.andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == AND_BOT) {
            boolean isPossible = tileXCoordinate >= 5 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate <= game.getYTiles() - 18;
            mouseStateChanger.andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == AND_LEFT) {
            boolean isPossible = tileXCoordinate >= 17 && tileYCoordinate >= 5 && tileYCoordinate <= game.getYTiles() - 4;
            mouseStateChanger.andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == AND_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 18 && tileYCoordinate >= 3 && tileYCoordinate <= game.getYTiles() - 6;
            mouseStateChanger.andMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == OR_TOP) {
            boolean isPossible = tileXCoordinate >= 1 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate >= 8;
            mouseStateChanger.orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == OR_BOT) {
            boolean isPossible = tileXCoordinate >= 3 && tileXCoordinate <= game.getXTiles() - 2 && tileYCoordinate <= game.getYTiles() - 9;
            mouseStateChanger.orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == OR_LEFT) {
            boolean isPossible = tileXCoordinate >= 8 && tileYCoordinate >= 3 && tileYCoordinate <= game.getYTiles() - 2;
            mouseStateChanger.orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == OR_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 9 && tileYCoordinate >= 1 && tileYCoordinate <= game.getYTiles() - 4;
            mouseStateChanger.orMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == XOR_TOP) {
            boolean isPossible = tileXCoordinate >= 2 && tileXCoordinate <= game.getXTiles() - 5 && tileYCoordinate >= 10;
            mouseStateChanger.xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == XOR_BOT) {
            boolean isPossible = tileXCoordinate >= 4 && tileXCoordinate <= game.getXTiles() - 3 && tileYCoordinate <= game.getYTiles() - 11;
            mouseStateChanger.xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == XOR_LEFT) {
            boolean isPossible = tileXCoordinate >= 10 && tileYCoordinate >= 4 && tileYCoordinate <= game.getYTiles() - 3;
            mouseStateChanger.xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == XOR_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 11 && tileYCoordinate >= 2 && tileYCoordinate <= game.getYTiles() - 5;
            mouseStateChanger.xorMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NAND_TOP) {
            boolean isPossible = tileXCoordinate >= 5 && tileXCoordinate <= game.getXTiles() - 8 && tileYCoordinate >= 13;
            mouseStateChanger.nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NAND_BOT) {
            boolean isPossible = tileXCoordinate >= 7 && tileXCoordinate <= game.getXTiles() - 6 && tileYCoordinate <= game.getYTiles() - 14;
            mouseStateChanger.nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NAND_LEFT) {
            boolean isPossible = tileXCoordinate >= 13 && tileYCoordinate >= 7 && tileYCoordinate <= game.getYTiles() - 6;
            mouseStateChanger.nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NAND_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 14 && tileYCoordinate >= 5 && tileYCoordinate <= game.getYTiles() - 8;
            mouseStateChanger.nandMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NOT_TOP) {
            boolean isPossible = tileXCoordinate >= 2 && tileXCoordinate <= game.getXTiles() - 4 && tileYCoordinate >= 11;
            mouseStateChanger.notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NOT_BOT) {
            boolean isPossible = tileXCoordinate >= 3 && tileXCoordinate <= game.getXTiles() - 3 && tileYCoordinate <= game.getYTiles() - 12;
            mouseStateChanger.notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NOT_LEFT) {
            boolean isPossible = tileXCoordinate >= 11 && tileYCoordinate >= 3 && tileYCoordinate <= game.getYTiles() - 3;
            mouseStateChanger.notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        } else if (mouseStateChanger.getInsertionFlag() == NOT_RIGHT) {
            boolean isPossible = tileXCoordinate <= game.getXTiles() - 12 && tileYCoordinate >= 2 && tileYCoordinate <= game.getYTiles() - 4;
            mouseStateChanger.notMouseControl(event, isPossible, tileXCoordinate, tileYCoordinate);
        }
    }
}
