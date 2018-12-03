package eksamenfeb2014;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.Calendar;

public class FXMLParkeringsOversiktController {
    private ParkeringsHus parkeringsHus = new ParkeringsHus();

    @FXML
    private Label lblUt;

    @FXML
    private TextField txtBilnummer;

    @FXML Label lblBeholdning;

    @FXML
    void inntjeningsinfo(ActionEvent event){
        lblUt.setText("Parkeringshuset har tjent: "  + parkeringsHus.inntjeningsInfo());
        lblBeholdning.setText(parkeringsHus.beholdning() + "");
    }


    @FXML
    void infoOmBil(ActionEvent event){
        lblUt.setText(parkeringsHus.bilInfo(txtBilnummer.getText()));
        lblBeholdning.setText(parkeringsHus.beholdning() + "");
    }

    @FXML
    void tilBorttauing(ActionEvent event){
        lblUt.setText(Arrays.toString(parkeringsHus.bortTauing(Calendar.getInstance())));
    }

    @FXML
    void fjernFraRegister(ActionEvent event){
        parkeringsHus.fjernBilene(parkeringsHus.bortTauing(Calendar.getInstance()));
        lblUt.setText("Bilene ble tauet bort");
    }
}
