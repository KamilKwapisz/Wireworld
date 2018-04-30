package UserInterface;

import java.io.IOException;

import UserInterface.Controllers.MainController;
import core.Board;
import core.Cell;
import core.WireworldSimulation;
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
        MainController mainController = loader.getController();
        primaryStage.setTitle("WireWorld");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("UserInterface/launcher.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
/*
        WireworldSimulation simulation = new WireworldSimulation(110, 1.0, mainController.getGame());
//        simulation.start();

        Board board = new Board(3,3);

        board.addCell(new Cell(0, 0, 1));
        board.addCell(new Cell(1, 0, 3));
        board.addCell(new Cell(2, 0, 2));

        board.addCell(new Cell(0, 1, 3));
        board.addCell(new Cell(1, 1, 2));
        board.addCell(new Cell(2, 1, 1));

        board.addCell(new Cell(0, 2, 1));
        board.addCell(new Cell(1, 2, 2));
        board.addCell(new Cell(2, 2, 3));
//        try{
//            Thread.sleep(5000);
//        } catch (Exception e){
//
//        }
        simulation.runSimulation(board);
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
