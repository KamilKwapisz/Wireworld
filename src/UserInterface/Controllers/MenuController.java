package UserInterface.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;


public class MenuController implements Initializable {

    @FXML
    private TextField genNumber;
    @FXML
    private Label currentGen;
    @FXML
    private Slider speedSlider;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeNumOfGen(InputMethodEvent event) {
    }
    
}
