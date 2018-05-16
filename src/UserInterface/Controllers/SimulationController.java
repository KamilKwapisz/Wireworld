package UserInterface.Controllers;

import UserInterface.Fxml.NumOfGenField;
import java.net.URL;
import java.util.ResourceBundle;
import core.WireworldSimulation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;


public class SimulationController implements Initializable {

    @FXML
    private NumOfGenField genNumber;
    @FXML
    private Label currentGen;
    @FXML
    private GridPane menuPane;
    @FXML
    private Button backwardB;
    @FXML
    private Button pauseB;
    @FXML
    private Button playB;
    @FXML
    private Button forwardB;
    @FXML
    private Slider delaySlider;
    @FXML
    private Label delayValue;
    @FXML
    private Button apply;
    
    private WireworldSimulation simulation;
    private int numberOfGenerations = 0;

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
        simulation.pause();
    }

    @FXML
    private void playSimulation(ActionEvent event) {
        if (simulation.isPaused()) {
            simulation.unpause();
//            simulation.runSimulation();
        }
    }

    @FXML
    private void nextGeneration(ActionEvent event) {
        simulation.nextGeneration();
    }

    public void loadSimulation(WireworldSimulation w_simulation){
        this.simulation = w_simulation;
        this.simulation.setCurrentGenNumberLabel(this.currentGen);
        this.simulation.runSimulation();
        this.simulation.pause();


    }

    @FXML
    private void applyGenNumber(ActionEvent event) {
        try{
        numberOfGenerations = Integer.parseInt(genNumber.getText());
        simulation.setNumberOfIterations(numberOfGenerations);
        } catch(NumberFormatException e){
            System.out.println("Number of generations is missing or is too big. Number of generations is beeing set to 0.");
            numberOfGenerations = 0;
            genNumber.setText("0");
        }
    }

    public Label getCurrentGen(){
        return this.currentGen;
    }



}
