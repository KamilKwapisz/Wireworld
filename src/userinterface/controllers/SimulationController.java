package userinterface.controllers;

import userinterface.dialogwindows.ErrorWindow;
import userinterface.dialogwindows.PopUpWindow;
import userinterface.fxml.NumOfGenField;
import java.net.URL;
import java.util.ResourceBundle;
import simulation.WireworldSimulation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;


public class SimulationController implements Initializable {

    @FXML
    private NumOfGenField genNumber;
    @FXML
    private Label currentGen;
    @FXML
    private Slider delaySlider;
    @FXML
    private Label delayValue;
    
    private WireworldSimulation simulation;
    private int numberOfGenerations = 0;
    private MediaPlayer musicPlayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        delaySlider.setValue(0.2);
        
        //delayValue.textProperty().bindBidirectional(delaySlider.valueProperty(), NumberFormat.getNumberInstance());
     
        delayValue.setText(Math.round(delaySlider.getValue()) + "");
        delaySlider.valueProperty().addListener(new ChangeListener<Number>() {
        @Override 
        public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
            if (newValue == null) {
                 delayValue.setText("");
                 return;
            }
            if(newValue.equals(0.08) && simulation.isPaused() == false && simulation.getNumberOfIterations() == 0){
                musicPlayer.play();
            } else{
                musicPlayer.pause();
            }
        delayValue.setText((Math.round(newValue.doubleValue() * 100.0) / 100.0) + "");
        simulation.setDelay(Math.round(newValue.doubleValue() * 100.0) / 100.0);
        
      }});
        
        delayValue.setText("0.2");
        genNumber.setText("0");
        
        
    }


    @FXML
    private void backGeneration(ActionEvent event) {
//        this.simulation.decrementCurrentGenNumber(); // decrementing current gen number
        this.simulation.loadLastGeneration();
    }

    @FXML
    private void pauseSimulation(ActionEvent event) {
        musicPlayer.pause();
        simulation.pause();
    }


    @FXML
    private void playSimulation(ActionEvent event) {
        if (simulation.isPaused()) {
            simulation.unpause();
//            simulation.runSimulation();
        }
        if(delaySlider.getValue() == 0.08 && simulation.getNumberOfIterations() == 0 ){
            musicPlayer.play();
        }
    }

    @FXML
    private void nextGeneration(ActionEvent event) {
        simulation.nextGeneration();
    }

    public void loadSimulation(WireworldSimulation wSimulation){
        this.simulation = wSimulation;
        this.simulation.setCurrentGenNumberLabel(this.currentGen);
        this.simulation.runSimulation();
        this.simulation.pause();
    }
    
    public void loadMediaPlayer(MediaPlayer musicPlayer){
        this.musicPlayer = musicPlayer;
    }
    

    @FXML
    private void applyGenNumber(ActionEvent event) {
        try{
            if(simulation.getCurrentGenerationNumber() == simulation.getNumberOfIterations()){
                simulation.runSimulation();
                simulation.pause();
            }

            numberOfGenerations = Integer.parseInt(genNumber.getText());
            simulation.setNumberOfIterations(numberOfGenerations);
            simulation.pause();
            musicPlayer.pause();
            simulation.setCurrentGenerationNumber(1);
        } catch(NumberFormatException e){
            PopUpWindow errorWindow = new ErrorWindow("Number of generations is missing or too big.\nNumber of generations is set to 0.");
            errorWindow.display();
            numberOfGenerations = 0;
            simulation.setNumberOfIterations(numberOfGenerations);
            genNumber.setText("0");
            simulation.pause();
            musicPlayer.pause();
            simulation.setCurrentGenerationNumber(1);
        }
    }

    public Label getCurrentGen(){
        return this.currentGen;
    }



}
