package UserInterface.Controllers;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;


public class MenuController implements Initializable {

    @FXML
    private TextField genNumber;
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        delaySlider.setValue(1);
        delayValue.setText(new Double(1).toString());
        delayValue.textProperty().bindBidirectional(delaySlider.valueProperty(), NumberFormat.getNumberInstance());

//        playB.setOnAction(e->simulation.run());
    }    

    @FXML
    private void changeNumOfGen(InputMethodEvent event) {
    }


}
