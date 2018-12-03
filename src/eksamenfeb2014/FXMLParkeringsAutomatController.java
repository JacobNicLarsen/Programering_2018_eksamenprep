package eksamenfeb2014;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.Calendar;

public class FXMLParkeringsAutomatController {
    ParkeringsHus parkeringsHus = new ParkeringsHus();

    @FXML
    private TextField txtBilnummer;

    @FXML
    private Label lblAvgift;

    @FXML
    private Label lblUt;


    @FXML
    void btnKorttidsParkering(ActionEvent event) {
        parkeringsHus.parker(txtBilnummer.getText(),Parkering.KORTTID);
        lblUt.setText("Bil parkert med korttidsparkering");
        System.out.println(Arrays.toString(parkeringsHus.getPlasser()));
    }

    @FXML
    void btnLangtidsParkering(ActionEvent event) {
        parkeringsHus.parker(txtBilnummer.getText(),Parkering.LANGTID);
        lblUt.setText("Bil parkert med langtidsparkering");
    }

    @FXML
    void btnUtkjøring(ActionEvent event) {
        lblUt.setText(parkeringsHus.hentBil(txtBilnummer.getText(),Calendar.getInstance()));
        lblAvgift.setText(parkeringsHus.avgift(txtBilnummer.getText(),Calendar.getInstance())+ "");
    }
}
