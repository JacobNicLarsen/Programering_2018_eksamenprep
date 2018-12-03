package valutakalkulator;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

class Valuta {
    // sort og kurs
    // konstruktør
    private String sort;
    private double kurs;

    Valuta(String sort, double kurs){
        this.sort = sort;
        this.kurs = kurs;
    }

    public String getSort(){
        return sort;
    }

    public double getKurs(){
        return kurs;
    }
}

class Kalkulator {

    ArrayList<Valuta> valutaer = new ArrayList<>();

    public void fyllListe() {
        // legg inn Valuta objekter i arrayet
        valutaer.add(new Valuta("NOK", 1.00));
        valutaer.add(new Valuta("SEK", 0.82));
        valutaer.add(new Valuta("USD", 10.12));
    }

    public String beregn(String valuta, String beløp) {
        // feilhåndter innlesning av tall
        // dersom det ikke er riktig returner feilmelding
        // ellers returner "Beregnet beløp blir ... kr".
        // bruk DecimalFormat df = new DecimalFormat("####0.00");
        // og df.format() for å få to desimaler

        for (Valuta enValuta : valutaer){
            if (enValuta != null) {
                if (enValuta.getSort().equals(valuta)) {
                    try {
                        double beløpBergen = Double.parseDouble(beløp);
                        return beløpBergen * enValuta.getKurs() + "";

                    } catch (Exception e) {
                        return "Skriv inn et gyldig tall";
                    }
                }
            }
        }
        return "Fant ikke valuta";
    }
}

public class FXMLValutakalkulatorController {

    Kalkulator kalkulator = new Kalkulator();

    @FXML
    private Label lblResultat;

    @FXML
    private TextField txtBeløp, txtValuta;

    @FXML
    void Beregn(ActionEvent event) {
        // kall fyllListe
        // kall beregn og legg resultatet ut i label'en
        kalkulator.fyllListe();
        lblResultat.setText(kalkulator.beregn(txtValuta.getText(), txtBeløp.getText()));
    }
}
